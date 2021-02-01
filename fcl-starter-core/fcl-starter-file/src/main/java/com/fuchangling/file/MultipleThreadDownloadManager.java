package com.fuchangling.file;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 多线程文件下载器
 * 不支持无法获取大小的的文件下载
 *
 * @author harlin
 */
public class MultipleThreadDownloadManager implements Runnable {
    /**
     * 下载链接
     */
    private String uri;
    /**
     * 文件存储位置
     */
    private File target;

    /**
     * 不许外部实例化无参构造
     */
    private MultipleThreadDownloadManager() {
    }

    public MultipleThreadDownloadManager(String uri, File target) {
        this.target = target;
        this.uri = uri;
    }

    /**
     * 开始下载
     */
    public void start() {
        if (!target.exists()) {
            try {
                boolean newFile = target.createNewFile();
                if (!newFile) {
                    throw new IOException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new Thread(this).start();
    }


    /**
     * 根据文件总大小计算线程数量
     *
     * @param totalSize 文件大小
     */
    public int threadCount(long totalSize) {
        if (totalSize < 30 * 2014 * 1024) {
            return 1;
        }
        return 30;
    }

    @Override
    public void run() {
        //获取文件总大小
        int totalSize = 0;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(uri).openConnection();
            connection.connect();
            totalSize = connection.getContentLength();
            if (totalSize == -1) {
                throw new NullPointerException("无法获取文件大小，请更换方式下载");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将文件分片并分开下载
        int threadCount = threadCount(totalSize);
        int perThreadSize = totalSize / threadCount;//每一个线程分到的任务下载量
        int id = 0;
        int from = 0, to = 0;
        while (totalSize > 0) {
            id++;
            //计算分片
            to = totalSize;
            from = totalSize - perThreadSize;
            if (from < 0) {
                from = 0;
            }
            totalSize -= perThreadSize;
            //开始下载
            UnitDownloader downloader = new UnitDownloader(from, to, target, uri, id);
            new Thread(downloader).start();
        }
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }
}