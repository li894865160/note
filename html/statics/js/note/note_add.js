$(document).ready(function() {

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