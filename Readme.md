###文件结构
```lua
fcl-cloud-parent -- 父项目，各模块分离，方便集成
|  |--fcl-starter-core -- 核心通用模块，主模块
|  |  |--fcl-starter-common -- 封装通用模块
|  |  |--fcl-starter-dependeencies 封装所有依赖模块，可作为父项目独立引用
```
```xml
    <dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.fuchangling</groupId>
            <artifactId>fcl-starter-dependencies</artifactId>
            <version>1.0-SNAPHOST</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

```