$(document).ready(function(){
    d3.select("#dropdown_button")
        .on('click', function(){
            let item= d3.select("#dropdown_item").style("display");
            console.log(d3.select("#dropdown_item").style);
            if( item==="block"){
                //alert("隐藏")
                d3.select("#dropdown_item").style('display', 'none');
            } else{
                //alert("显示")
                d3.select("#dropdown_item").style('display', 'block');
            }
        });

    let lala = d3.selectAll(".dropdown_item_li")
        .on('click', function(){
            //console.log(d3.select("#dropdown_button").text());
            //console.log(d);
            let schema=d3.select(this).text();
            console.log(schema);
            d3.select("#dropdown_button").text(schema);
            if(schema==="Action Scheme"){
                d3.selectAll(".s_scheme").classed('s_scheme_active',false)
                d3.select("#a_scheme_input").classed("s_scheme_active", true);

                d3.selectAll(".s_example").classed('s_example_active',false)
                d3.select("#action_ex_scheme_input").classed("s_example_active", true);

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#a_cq_input").classed("c_question_active", true);

            }if(schema==="Expert Opinion Scheme"){
                d3.selectAll(".s_scheme").classed('s_scheme_active',false)
                d3.select("#ex_scheme_input").classed("s_scheme_active", true);

                d3.selectAll(".s_example").classed('s_example_active',false)
                d3.select("#expert_ex_scheme_input").classed("s_example_active", true);

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#ex_cq_input").classed("c_question_active", true);
            }
        });

    $("#a_schema_button").click(function(){
        alert("点击成功"+$("#a_action").val());
        $.ajax({
            url:"/argument/a",
            type:"post",
            data: JSON.stringify({"current":$("#a_r").val(),"action":$("#a_action").val(),"new_s":$("#a_s").val(),"goal":$("#a_goal").val(),"value":$("#a_value").val()}),
            contentType: 'application/json;charset=utf-8',
            //dataType:"json",
            success:function(data){
                alert(data);
                alert("success")
            },
            error:function(){
                alert("fail");
            }
        })
    });

});




/*.on("mouseout", function(){
    d3.select("#dropdown_item").style('display', 'none')
})*/

