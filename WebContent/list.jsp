<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
<table width="400" border="0" cellspacing="0" cellpadding="0">
	<tr>
		
		<td>名称</td>
		<td>价格</td>
		<td>商品数量</td>
		<td>购买数量</td>
		<td>操作</td>
	</tr>

<c:forEach var="goods" items="${goodlist}">
	<tr>
		<td>${goods.name}</td>
		<td>${goods.price}</td>
		<td>${goods.number}</td>
		<td>
		<span id="buyNum"></span>
		<input type="button" onclick="Plus('${goods.number}')" value="+">
		<input type="button" onclick="Minus('${goods.number}')" value="-">
		</td>
		<td><input type="button" onclick="buyGoods('${goods.id}')" value="点击购买该商品"></td>
		
	</tr>
</c:forEach>
</table>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	$("#buyNum").html("0");	
})
function Plus(number){
	var buynum =$("#buyNum").text();
	if(buynum==number){
		alert("客官本次最多买"+number+"，库存不足");
	}else{
		buynum++;
		$("#buyNum").html(buynum);
	}	
}
function Minus(number){
	var buynum =$("#buyNum").text();
	if(buynum==0){
		alert("客官，购买数量为0欧，不能再减了");
	}else{
		buynum--;
		$("#buyNum").html(buynum);
	}
}
function buyGoods(id){
	var buynum =$("#buyNum").text();
	alert(id+"  "+buynum);
	if(buynum==0){
		alert("现在购买数量为0，请点击+")
	}else{
		$.ajax({
			url:"/TestServlet/updateGoods",
			type:"get",			
			data:{"id":id,"buynum":buynum},
			dataType:"json",
			success:function(result){
				alert("购买成功")
				location.href="/TestServlet/findAll";
			}
		
		})
	}
}
/*商品购买成功后，跳转回来时需要通过js进行页面刷新  */
$(function(){
	//location.reload();
})
</script>
</body>
</html>