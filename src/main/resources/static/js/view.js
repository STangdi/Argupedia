function initial() {
    $.ajax({
        url: "/view/All",
        type: "post",
        contentType: 'application/json;charset=utf-8',
        dataType: "json",
        async: false,
        success: function (framedata) {

            allFrame = framedata;
            console.log(framedata);
            let frame_length = framedata.length;
            let framelist = d3.select("#argLists").selectAll('div')
                .data(framedata)
                .enter()
                .append('div')
                .attr("class","framework")
                .append("form")
                .attr("method","post")
                .attr("action","/view/viewone");
            let frame = framelist.append('p');
            frame.append('input')
                .attr("type","hidden")
                .property("name","selectedFid")
                .property('value', function(d){
                    console.log(d);
                    return d[0];
                });
            frame.append('span')
                .attr("class","frameid")
                .text(function(d){
                    console.log(d);
                    return d[0];
                });
            frame.append('span')
                .attr("class","titile")
                .append("button")
                .attr("type","submit")
                .text(function(d){
                    //console.log(d);
                    return d[1];
                });
            let arg = frame.append('span')
                .attr("class","arg")
            arg.append("i")
                .attr("class","bi bi-chat-right-dots");
            arg.append('span')
                .attr("class","argnum")
                .text(function(d){
                    //console.log(d);
                    return d[2];
                });
        }
    });
}
initial();
function  search(searchdata){
    let frame_length = searchdata.length;
    let searchlist = d3.select("#argLists").selectAll('div')
        .data(searchdata)
        .enter()
        .append('div')
        .attr("class","framework")
        .append("form")
        .attr("method","post")
        .attr("action","/view/viewone");
    let searchframe = searchlist.append('p');
    searchframe.append('input')
        .attr("type","hidden")
        .property("name","selectedFid")
        .property('value', function(d){
            console.log(d);
            return d[0];
        });
    searchframe.append('span')
        .attr("class","frameid")
        .text(function(d){
            console.log(d);
            return d[0];
        });
    searchframe.append('span')
        .attr("class","titile")
        .append("button")
        .attr("type","submit")
        .text(function(d){
            //console.log(d);
            return d[1];
        });
    let searcharg = searchframe.append('span')
        .attr("class","arg")
    searcharg.append("i")
        .attr("class","bi bi-chat-right-dots");
    searcharg.append('span')
        .attr("class","argnum")
        .text(function(d){
            //console.log(d);
            return d[2];
        });
}

    d3.select("#search_btn")
        .on("click",function(){
            let str = d3.select("#search_input").property("value");
            console.log(str);
            $.ajax({
                url: "/view/searchTitle",
                type: "post",
                contentType: 'application/json;charset=utf-8',
                data:str,
                //dataType: "json", //'application/json;charset=utf-8',
                async: false,
                success: function(result){
                    alert(result);
                    if(result==="fail"){
                        alert("The query content does not exist, please refresh and reload the page");
                        initial();
                    }else{
                        d3.select("#argLists").selectAll('div').remove();
                        search(result);
                    }
                },
                error:function(){
                    alert("fail");
                }
            });
        });




