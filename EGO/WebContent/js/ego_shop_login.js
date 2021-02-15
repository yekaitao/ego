   //账号框正在输入时
   $('#nickname').focus(function () {
     $('#nicknameJudge').text("")
     $('#upasswordTrue').removeClass('has-error')
     $('#upasswordSpan').removeClass('glyphicon-remove')
   })
   // 密码框正在输入时
   $('#upassword').focus(function () {
     $('#nicknameJudge').text("")
     $('#upasswordTrue').removeClass('has-error')
     $('#upasswordSpan').removeClass('glyphicon-remove')
   })

   // 点击登录按钮后
   $('#login').click(function () {
     let nickname = $('#nickname').val()
     let upassword = $('#upassword').val()
     // 用来判断是普通用户还是超级用户
     let JudgeUser = $("input[name='loginuserJudge']:checked").val()
     // 判断是普通用户还是超级用户
     if(JudgeUser == "ordinary"){
    	 $.ajax({
    		 type: "POST",
    		 url: "http://localhost:8080/EGO/login",
    		 data: JSON.stringify({nickname:nickname,upassword:upassword}),
    		 dataType: "json",
    		 contentType:"application/json; charset=utf-8",
    		 traditional: true, // traditional 为true阻止深度序列化
    		 success: function (data, msg, xhr) {
    			 console.log('异步请求登录API成功', data)
    			 if (data.code == "506") {
    				 $('#nicknameJudge').text('账号或密码不正确')
    				 $('#upasswordTrue').addClass('has-error')
    				 $('#upasswordSpan').addClass('glyphicon-remove')
    				 $('#upassword').val("")
    				 return
    			 }
    			 if (data.code == "200") {
    				 console.log(data.uid)
    				 window.sessionStorage.setItem('uid',data.result.uid)
    				 window.sessionStorage.setItem('nickname',data.result.nickname)
    				 window.location.href = "ego_shop_personal.html"   // 跳转到首页推荐
    			 }
    		 },
    		 error: function (xhr, err) {
    			 console.log('异步请求登录API失败：')
    			 console.log(xhr)
    			 console.log(err)
    		 }
    	 })
     }
     if(JudgeUser == "root"){
    	 $.ajax({
    		 type: "POST",
    		 url: "http://localhost:8080/EGO/root",
    		 data: JSON.stringify({nickname:nickname,upassword:upassword,JudgeUser:JudgeUser}),
    		 dataType: "json",
    		 contentType:"application/json; charset=utf-8",
    		 traditional: true, // traditional 为true阻止深度序列化
    		 success: function (data, msg, xhr) {
    			 console.log('异步请求登录API成功', data)
    			 if (data.code == "506") {
    				 $('#nicknameJudge').text('账号或密码不正确')
    				 $('#upasswordTrue').addClass('has-error')
    				 $('#upasswordSpan').addClass('glyphicon-remove')
    				 $('#upassword').val("")
    				 return
    			 }
    			 if (data.code == "200") {
    				 window.location.href = "admin_index.html"   // 跳转到超级用户页面
    			 }
    		 },
    		 error: function (xhr, err) {
    			 console.log('异步请求登录API失败：')
    			 console.log(xhr)
    			 console.log(err)
    		 }
    	 })
     }
   })
