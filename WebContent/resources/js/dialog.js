$(document).ready(function() {
	$(function() {
		$("#dialog").dialog({
			autoOpen : false,
			resizable : false,
			width : '401px',
		});
		$("#button").on("click", function() {
			$("#dialog").dialog("open");
		});
	});

	// validating Form Fields.....
	/*$("#submit").click(function(e) {

		var projectname = $("#frmProjName").val();
		var startdate = $("#frmProjStartDate").val();
		var enddate = $("#frmProjEndDate").val();

		if (projectname === '' || startdate === '' || enddate === '') {
			alert("Please fill all fields!");

		}
	});*/
});
