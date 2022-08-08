$(document).ready(function(){
    d3.select("#dropdown_button")
        .on('click', function(){
            let item= d3.select("#dropdown_item").style("display");
            console.log(d3.select("#dropdown_item").style);
            if( item==="block"){
                d3.select("#dropdown_item").style('display', 'none');
            } else{
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

            }
            if(schema==="Expert Opinion Scheme"){
                d3.selectAll(".s_scheme").classed('s_scheme_active',false)
                d3.select("#ex_scheme_input").classed("s_scheme_active", true);

                d3.selectAll(".s_example").classed('s_example_active',false)
                d3.select("#expert_ex_scheme_input").classed("s_example_active", true);

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#ex_cq_input").classed("c_question_active", true);
            }
            if(schema==="Popular Opinion Scheme"){
                d3.selectAll(".s_scheme").classed('s_scheme_active',false)
                d3.select("#pop_scheme_input").classed("s_scheme_active", true);

                d3.selectAll(".s_example").classed('s_example_active',false)
                d3.select("#popular_pop_scheme_input").classed("s_example_active", true);

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#pop_cq_input").classed("c_question_active", true);
            }
            if(schema==="Position to Know Scheme"){
                d3.selectAll(".s_scheme").classed('s_scheme_active',false)
                d3.select("#posi_scheme_input").classed("s_scheme_active", true);

                d3.selectAll(".s_example").classed('s_example_active',false)
                d3.select("#position_posi_scheme_input").classed("s_example_active", true);

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#posi_cq_input").classed("c_question_active", true);
            }
            if(schema==="Analogy Scheme"){
                d3.selectAll(".s_scheme").classed('s_scheme_active',false)
                d3.select("#ana_scheme_input").classed("s_scheme_active", true);

                d3.selectAll(".s_example").classed('s_example_active',false)
                d3.select("#analogy_ana_scheme_input").classed("s_example_active", true);

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#ana_cq_input").classed("c_question_active", true);
            }
            if(schema==="Correlation to Cause Scheme"){
                d3.selectAll(".s_scheme").classed('s_scheme_active',false)
                d3.select("#corr_scheme_input").classed("s_scheme_active", true);

                d3.selectAll(".s_example").classed('s_example_active',false)
                d3.select("#correlation_corr_scheme_input").classed("s_example_active", true);

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#corr_cq_input").classed("c_question_active", true);
            }
        });
});
