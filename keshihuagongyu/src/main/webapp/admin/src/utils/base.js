const base = {
    get() {
        return {
            url : "http://localhost:8080/keshihuagongyu/",
            name: "keshihuagongyu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/keshihuagongyu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "可视化高校公寓"
        } 
    }
}
export default base
