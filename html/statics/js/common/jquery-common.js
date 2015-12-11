(function($) {
	
	
		/**
		 * bootstrap-bootstrapTable
		 * @param options
		 */
		$.fn.commonbootstrapTable = function(options) {
			var settings = {
				method: 'get',
				pagination: true,
				sidePagination: "server",
				pageList: "[5, 10, 20, 50, 100, 200, 500, 1000]"
			};
			options = $.extend(settings, options);
			with({
				dom: this
			}) {
				options.onLoadSuccess = function(r) {
					if (r.code == 201) {
						window.location.href = '/html/login.html';
						return;
					} else if (r.code != 200) {
						//判断code类型，做相应处理
						alert(r.message);
					} else {
						var d = r.data;
						var data = {};
						data.total = d.total;
						data.rows = d.result;
						$(dom).bootstrapTable('load', data);
					}
				}
			}
			$(this).bootstrapTable(options);
		}
	

})(jQuery);