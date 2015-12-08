var tags = "";
var category = "";
$(document).ready(function() {

	$.ajax({  
	     url:'/web/category/list',// 跳转到 action  
	     
	     type:'post',  
	     cache:false,  
	     dataType:'json',  
	     async:false,
	     success:function(data) {  
	         if(data.code=200){
	        	 $.each(data.rows, function (i, item) {  
	        		 category += "<label class=\"btn btn-default\">";
	        		 category += "<input type=\"radio\" name=\"category\" value=\""+item.id+"\" />"+item.title;
	        		 category += "</label>";
	             });
	         }
	         $("#category").html(category);
	      },  
	      error : function() {  
	           alert("异常！");  
	      }  
	 });
	
	 $.ajax({  
		     url:'/web/tag/list',// 跳转到 action  
		     
		     type:'post',  
		     cache:false,  
		     dataType:'json',  
		     async:false,
		     success:function(data) {  
		         if(data.code=200){
		        	 $.each(data.rows, function (i, item) {  
		                 tags += "<label class=\"btn btn-default\">";
		                 tags += "<input type=\"checkbox\" name=\"tags\" value=\""+item.id+"\" />"+item.title;
		                 tags += "</label>";
		             });
		         }
		         $("#tags").html(tags);
		      },  
		      error : function() {  
		           alert("异常！");  
		      }  
		 });
	
    $('#addNoteForm').bootstrapValidator({
//        live: 'disabled',
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	title: {
                validators: {
                    notEmpty: {
                        message: '标题不能为空'
                    }
                }
            },
            category: {
                validators: {
                    notEmpty: {
                        message: 'The gender is required'
                    }
                }
            },
            tags: {
                validators: {
                    choice: {
                        min: 1,
                        max: 2,
                        message: 'Please choose 1 - 2 languages you can speak'
                    }
                }
            }
        }
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#addNoteForm').bootstrapValidator('validate');
    });

    $('#resetBtn').click(function() {
        $('#addNoteForm').data('bootstrapValidator').resetForm(true);
    });
});