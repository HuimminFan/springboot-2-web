/**
 * Created by fanhuimin.tp on 2018/7/17.
 */
$(function () {
    initLayPage();
});

/**
 * 初始化layui分页
 */

function initLayPage(pageConf) {
    if(!pageConf){
        pageConf ={};
        pageConf.pageSize = 10;
        pageConf.currentPage = 1;

    }
    $.post("/test/query", pageConf, function (data) {
        layui.use(['laypage', 'layer'], function () {
            var page = layui.laypage;
            page.render({
                elem: 'layui',
                count: data.total,
                curr: pageConf.currentPage,
                limit: pageConf.pageSize,
                first:"首页",
                last:"尾页",
                layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
                jump: function (obj, first) {
                    if (!first) {
                        pageConf.currentPage = obj.curr;
                        pageConf.pageSize = obj.limit;
                        initLayPage(pageConf);
                    }
                }
            });
            fillTable(data.list,(pageConf.currentPage - 1) * pageConf.pageSize); //页面填充
        })
    });
}
//填充表格数据
// function fillTable(data,num) {
//     var info = '';
//     $.each(data, function (index, obj) {
//         // id 很多时候并不是连续的，如果为了显示比较连续的记录数，可以这样根据当前页和每页条数动态的计算记录序号
//         index = index +num+1;
//         info += '<tr><td>' + index + '</td><td>' + obj.name + '</td><td>' + obj.age + '</td>' +
//             '<td style="text-align: center;"><button name="btnModify" type="button" class="btn btn-success btn-xs" >修改</button>' +
//             '<button name="btnDelete" type="button" class="btn btn-danger btn-xs" onclick="remove(' + obj.id + ')">删除</button></td></tr>';
//     });
//     $("#tab_list").html(info);
// }