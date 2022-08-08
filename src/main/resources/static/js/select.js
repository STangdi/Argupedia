function drawArgumentCard(svgid, dataset){
    let argData={
        title:"Action Scheme",
        current_R: "COVID-19 is spreading rapidly.",
        action:"Full lockdown.",
        new_S:"The number of confirmed cases is falling.",
        goal:"G is stop the spread of COVID-19.",
        value:"The value is public health"
    };

    let g = new dagreD3.graphlib.Graph();

    g.setGraph({
        rankdir:'BT'
        //width: 740
    });

    dataset.nodes.forEach(item => {
        let arg_shape="";
        console.log(item);
        if(item.type==="Action"){
            arg_shape="<div class='one_argument argument_card'>" +
                "<div class='argument_card_header' >"+item.type+" Scheme</div>"+
                "<div class='one_argument_content'>" +
                "<p>Argument: <span class='afid'>"+item.id+"</span></p>" +
                "<p class='a_label'>label: "+item.label+"</p>" +
                "<p>R: "+item.currentR+"</p>" +
                "<p>A: "+item.action+"</p>" +
                "<p>S: "+item.new_s+"</p>" +
                "<p>G: "+item.goal+"</p>" +
                "<p>V: "+item.value+"</p>" +
                "</div>" +
                "<div class='one_argument_challenge'><button class='c_butt'><i class='bi bi-chat-text-fill'></i></button><button class='h_butt'><i class='bi bi-hand-thumbs-up-fill'></i><span class='votenums'>"+item.vote+"</span></button></div>" +
                "</div>";
        }
        if(item.type==="Expert Opinion"||item.type==="Position to Know"){
            arg_shape="<div class='one_argument argument_card'>" +
                "<div class='argument_card_header' >"+item.type+" Scheme</div>"+
                "<div class='one_argument_content'>" +
                "<p>Argument: <span class='afid'>"+item.id+"</span></p>" +
                "<p class='a_label'>label: "+item.label+"</p>" +
                "<p>MajorPremise: "+item.majorPremise+"</p>" +
                "<p>MinorPremise: "+item.minorPremise+"</p>" +
                "<p>Conclusion: "+item.conclusion+"</p>" +
                "</div>" +
                "<div class='one_argument_challenge'><button class='c_butt'><i class='bi bi-chat-text-fill'></i></button><button class='h_butt'><i class='bi bi-hand-thumbs-up-fill'></i><span class='votenums'>"+item.vote+"</span></button></div>" +
                "</div>";
        }
        if(item.type==="Popular Opinion"){
            arg_shape="<div class='one_argument argument_card'>" +
                "<div class='argument_card_header' >"+item.type+" Scheme</div>"+
                "<div class='one_argument_content'>" +
                "<p>Argument: <span class='afid'>"+item.id+"</span></p>" +
                "<p class='a_label'>label: "+item.label+"</p>" +
                "<p>Generally Acceptance Premise: "+item.gaccPremise+"</p>" +
                "<p>Presumption Premise: "+item.presuPremise+"</p>" +
                "<p>Conclusion: "+item.conclusion+"</p>" +
                "</div>" +
                "<div class='one_argument_challenge'><button class='c_butt'><i class='bi bi-chat-text-fill'></i></button><button class='h_butt'><i class='bi bi-hand-thumbs-up-fill'></i><span class='votenums'>"+item.vote+"</span></button></div>" +
                "</div>";
        }
        if(item.type==="Analogy"){
            arg_shape="<div class='one_argument argument_card'>" +
                "<div class='argument_card_header' >"+item.type+" Scheme</div>"+
                "<div class='one_argument_content'>" +
                "<p>Argument: <span class='afid'>"+item.id+"</span></p>" +
                "<p class='a_label'>label: "+item.label+"</p>" +
                "<p>Similarity Premise: "+item.similarPremise+"</p>" +
                "<p>Base Premise: "+item.basePremise+"</p>" +
                "<p>Conclusion: "+item.conclusion+"</p>" +
                "</div>" +
                "<div class='one_argument_challenge'><button class='c_butt'><i class='bi bi-chat-text-fill'></i></button><button class='h_butt'><i class='bi bi-hand-thumbs-up-fill'></i><span class='votenums'>"+item.vote+"</span></button></div>" +
                "</div>";
        }
        if(item.type==="Correlation to Cause"){
            arg_shape="<div class='one_argument argument_card'>" +
                "<div class='argument_card_header' >"+item.type+" Scheme</div>"+
                "<div class='one_argument_content'>" +
                "<p>Argument: <span class='afid'>"+item.id+"</span></p>" +
                "<p class='a_label'>label: "+item.label+"</p>" +
                "<p>Correlation Premise: "+item.corrPremise+"</p>" +
                "<p>Conclusion: "+item.conclusion+"</p>" +
                "</div>" +
                "<div class='one_argument_challenge'><button class='c_butt'><i class='bi bi-chat-text-fill'></i></button><button class='h_butt'><i class='bi bi-hand-thumbs-up-fill'></i><span class='votenums'>"+item.vote+"</span></button></div>" +
                "</div>";
        }

        g.setNode(item.id, {
            label: arg_shape,
            labelType: 'html',
            style: "fill:#fff;stroke:rgba(0,0,0,.125); rx:10; ry:10"
        })
    })
    dataset.edges.forEach(item => {
        g.setEdge(item.source,item.target, {
            label: item.label,
            style: "fill:#F8F4F1;stroke:#333;stroke-width:1.5px"
        })
    })
    let render = new dagreD3.render();
    let svgGroup = d3.select(svgid).append('g');
    render(svgGroup, g);
}
function dataProcessing(selectsvg, dataTest){
    let frame_length = dataTest.length;
    const innerData = {
        nodes:[],
        edges: []
    };
    let nodes1=[];
    let edges1=[];
    for(var i=0;i<frame_length;i++){
        let node={};
        let edge={};
        console.log(dataTest[i].afid);
        node.shape= "rect";
        node.id=dataTest[i].afid;
        console.log(dataTest[i].schema.type);
        node.type=dataTest[i].schema.type;
        node.label=dataTest[i].label;
        node.vote=dataTest[i].vote;
        for(var key in dataTest[i].schema){
            if(dataTest[i].schema[key]!=null){
                node[key]=dataTest[i].schema[key];
            }
        }
        console.log(dataTest[i].attack);
        console.log(dataTest[i].attacked_by);
        if(dataTest[i].attack!==""){ //&& dataTest[i].attacked_by!==""
            edge.source=dataTest[i].afid;
            edge.target=dataTest[i].attack;
            edge.label="";
            edges1.push(edge);
        }
        nodes1.push(node);
    }
    innerData.edges=edges1;
    innerData.nodes=nodes1;
    console.log(innerData);
    drawArgumentCard(selectsvg, innerData);
}
function initFramework() {
    let ifid = d3.select("#Fid").property("value");
    console.log(ifid);
    $.ajax({
        url:"/view/displayFramework",
        type:"post",
        contentType: 'application/json;charset=utf-8',
        data:ifid,
        //dataType:"json",
        async:false,
        success:function(argdata){
            let normalsvg ="#normal";
            dataProcessing(normalsvg, argdata);
        },
        error:function(error){
            console.log(error);
        }
    });
}

//$(document).ready(function() {

    initFramework();
//});




$(document).ready(function(){

    //argument card color
    d3.selectAll(".one_argument_content").each(function() {
        let label = d3.select(this).select(".a_label").text();
        console.log(label);
        if (label === "label: IN") {
            d3.select(this.parentNode)
                .style("color", "#fff")
                .style("background-color", "#28a745"); //IN
        }
        if (label === "label: OUT") {
            d3.select(this.parentNode)
                .style("color", "#fff")
                .style("background-color", "#dc3545"); //OUT
        }
    });

    //Challenge Function
    d3.selectAll(".c_butt")
        .on('click', function(){
            d3.selectAll(".one_argument").classed('one_argument_selected',false)
            let argument_card =  d3.select(this.parentNode.parentNode);
            //argument_card.classed("one_argument_selected", true);
            d3.select(this.parentNode.parentNode).style("background-color","#FF9B4F").style("color","#fff");
            //alert("You have decided to challenge this argument, please note the right hand side of this page and we will refresh the corresponding critical questions for you.");
            let challengedAfid = argument_card.select(".one_argument_content").select("p").select(".afid").text();
            console.log("challengedAfid: "+challengedAfid);

            console.log(d3.select("#Fid").property("value"));
            d3.selectAll(".chall_fid").property("value",d3.select("#Fid").property("value"));
            d3.selectAll(".chall_afid").property("value",challengedAfid); //str);
            let change= d3.select("#a_cq_input").style("display");
            let scheme_type = argument_card.select(".argument_card_header").text();
            console.log(scheme_type)
           if(scheme_type==="Action Scheme"){

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#a_cq_input").classed("c_question_active", true);
            }
           if(scheme_type==="Expert Opinion Scheme"){

               d3.selectAll(".c_question").classed('c_question_active',false)
               d3.select("#ex_cq_input").classed("c_question_active", true);
           }
           if(scheme_type==="Position to Know Scheme"){

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#posi_cq_input").classed("c_question_active", true);
            }
            if(scheme_type==="Popular Opinion Scheme"){

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#pop_cq_input").classed("c_question_active", true);
            }
            if(scheme_type==="Analogy Scheme"){

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#ana_cq_input").classed("c_question_active", true);
            }
            if(scheme_type==="Correlation to Cause Scheme"){

                d3.selectAll(".c_question").classed('c_question_active',false)
                d3.select("#corr_cq_input").classed("c_question_active", true);
            }
        });

    let voteButton;
    d3.selectAll(".h_butt")
        .on('click', function() {

            d3.selectAll(".one_argument").classed('one_argument_selected', false)
            voteButton=d3.select(this).select(".votenums");

            // get afid
            let argument_card = d3.select(this.parentNode.parentNode);
            let voteAfid = argument_card.select(".one_argument_content").select("p").select(".afid").text();
            d3.select("#saveV").property("value",voteAfid)
            $('#myModal').modal('show');

        });
    d3.select("#confirmV")
        .on('click', function() {
            $('#myModal').modal('hide');
            // get Fid
            d3.selectAll(".chall_fid").property("value", d3.select("#Fid").property("value"));
            // get afid
            let voteAfid2 = d3.select("#saveV").property("value");
            console.log("afid: " + voteAfid2);
            console.log("Fid"+d3.select("#Fid").property("value"));
            $.ajax({
                url:"/view/addvote",
                type:"post",
                data: JSON.stringify({"currentFid":d3.select("#Fid").property("value"),"attacked_afid":voteAfid2,"type":"vote"}),
                contentType: 'application/json;charset=utf-8',
                //dataType:"json",
                async:false,
                success:function(result){
                    if(result==="success"){
                        alert("You have successfully voted.");
                        let addVote = voteButton.text();
                        console.log(addVote);
                        console.log(typeof addVote);
                        console.log(Number(addVote) + 1);
                        voteButton.text(Number(addVote) + 1);
                    }else{
                        alert("We are sorry that the vote failed. Please try again later.");
                    }
                },
                error:function(){
                    alert("We are sorry that the vote failed. Please try again later.");
                }
            })
        });
    d3.select("#votestop")
        .on('click', function(){
            d3.select("#normal").classed("svg_active", true);
            d3.select("#votesvg").classed("svg_active", false);
        });
    d3.select("#votestart")
        .on('click', function(){
            console.log("Fid"+d3.select("#Fid").property("value"));
            $.ajax({
                url:"/view/vote",
                type:"post",
                data: d3.select("#Fid").property("value"),
                contentType: 'application/json;charset=utf-8',
                //dataType:"json",
                async:false,
                success:function(argresult){
                    alert("Please wait, it's loading for you.");
                    d3.select("#normal").classed("svg_active", false);
                    d3.select("#votesvg").classed("svg_active", true);
                    let vote_svg = "#votesvg";
                    dataProcessing(vote_svg, argresult);
                    d3.selectAll(".one_argument_content").each(function() {
                        let label = d3.select(this).select(".a_label").text();
                        console.log(label);
                        if (label === "label: IN") {
                            d3.select(this.parentNode)
                                .style("color", "#fff")
                                .style("background-color", "#28a745"); //IN
                        }
                        if (label === "label: OUT") {
                            d3.select(this.parentNode)
                                .style("color", "#fff")
                                .style("background-color", "#dc3545"); //OUT
                        }
                    });
                },
                error:function(){
                    alert("error");
                }
            })
        });

});

window.onscroll = function(){
    let scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
    //console.log(scrollTop);
    if(scrollTop>100){
        d3.select("#one_argu_critical_question")
            .transition()
            .style("top","51px");
    }else{
        d3.select("#one_argu_critical_question")
            .transition()
            .style("top","215px");
    }
};
