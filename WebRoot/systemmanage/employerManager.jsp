<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/style.css"  rel="stylesheet" type="text/css">
<title>无标题文档</title>
<script type="text/javascript" src="../js/jquery.min.js">
</script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"http://localhost:8080/oa/department/list.action",
		type:"post",
		dataType:"json",
		success:function(result){
			//将返回的department对象数组形成option选项
			for(i=0;i<result.length;i++){
				var deptName = result[i].departmentName;
				var deptId = result[i].departmentID+"";
				//判断是否设置为选中
				var $opt = "";
				var input_deptId = ${deptId}+"";
				if(input_deptId == deptId){
					$opt = $("<option selected  value='"+deptId+"'>"+deptName+"</option>");
				}else{
					$opt = $("<option  value='"+deptId+"'>"+deptName+"</option>");
				}
				
				$("#dept").append($opt);
			}
			
			
		}
	});
});
//分页函数
function goPage(page){
	$("#page").val(page);
	$("#search_form").submit();
}
</script>
</head>

<body>
<table border="0" style="border-collapse:collapse" width="780" background="back2.gif">
<tr>
<td>
<table width="780"style="border-collapse:collapse"  border="0">
  <tr>
    <td><center>员工信息维护</center></td>
  </tr>
  <tr>
  <form id="search_form" method="post" action="/oa/user/list.action">
    <td height="29">&nbsp;&nbsp;&nbsp;&nbsp;
      <a href=addEmployer.html>新建员工</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	选择部门：<select name="deptId" id="dept">
		<option value="-1">--请选择--</option>
    </select>	&nbsp;&nbsp;&nbsp;
	输入查询人姓名：
	<input type = "text" name="name" value="${name }" height="18">&nbsp;&nbsp;&nbsp;
	<input type="hidden" id="page" name="page" value="1">
	<input type = "submit" value = "查询"></td>
  </form>
  </tr>
  <tr>
    <td>
   <table width="780" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="100%" ><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="B1BCEC">
            <tr> 
              <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
                  <tr> 
                    <td height="6"   bgcolor="#D3E3F5" ><img src="../image/a666nniu020.jpg" width="1" height="1"></td>
                  </tr>
                </table>
                <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                  <tr bgcolor="EEF2FD"> 
                    <td width="8%"><div align="center">员工编号</div></td>
                    <td width="8%"><div align="center">姓名</div></td>
                    <td width="8%" height="23"><div align="center">性别</div></td>
                    <td width="8%"><div align="center">年龄</div></td>
                    <td width="8%"><div align="center">所属部门</div></td>
					<td width="8%"><div align="center">自我介绍</div></td>
					<td width="8%"><div align="center">兴趣爱好</div></td>
					<td width="8%"><div align="center">办公电话</div></td>
					<td width="8%"><div align="center">移动电话</div></td>
					<td width="8%"><div align="center">电子邮件</div></td>
					<td colspan="2"><div align="center">操作</div>					  </td>
					</tr>
			<c:forEach items="${users}" var="u">
                  <tr bgcolor="#FFFFFF"> 
                    <td>${u.userID }</td>
                    <td><div align="center">${u.username }</div></td>
                    <td><div align="center">${u.sex==1?"男":"女" }</div></td>
                    <td><div align="center">${u.age }</div></td>
                    <td><div align="center">${u.dept.departmentName }</div></td>
                    <td>...</td>
					<td>...</td>
					<td>${u.phone }</td>
					<td>${u.mobilephone}</td>
					<td>${u.email }</td>
					<td width="8%"><div align="center"><a href="modifyEmployer.html">修改</a></div></td>
					<td width="8%"><div align="center"><a href="#">删除</a></div></td>
                  </tr>
              </c:forEach>
             
                </table></td>
            </tr>
          </table></td>
        <td width="4" valign="top" background="../image/danghangbg6.jpg"><img src="../image/danghangbg7.jpg" width="4" height="6"></td>
      </tr>
      <tr> 
        <td background="../image/danghangbg5.jpg"><img src="../image/danghangbg3.jpg" width="6" height="4"></td>
        <td><img src="../image/danghangbg4.jpg" width="4" height="4"></td>
      </tr>
    </table>
	</td>
  <tr>
    <td align="center">
	     第${page }页　共10页　
	   <a href="javascript:goPage(1);">首页</a>
	   <a href="javascript:goPage(${page-1 });">上一页</a>
	     <a href="javascript:goPage(${page+1 });">下一页</a> 
	   尾页  
   转至
   <select onchange="goPage(this.value)">
       <option selected>1</option>
	   <option>2</option>
	   <option>3</option>
	   </select>	  </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>
