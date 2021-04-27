/**
 *  
 */

function checkAddProduct(){
	var productId = document.getElementById("productId");
	var name = document.getElementById("name");
	var unitPrice=document.getElementById("unitPrice");
	var unitsInStock = document.getElementById("unitsInStock");
	
	var regExpProductId = /^P[0-9]{4,11}$/;
	if(regExpProductId.test(productId)){
		alert("[상품코드]\n최소 4자에서 최대 11자까지 입력할 수 있습니다.");
		productId.focus();
		
		return false;
	} // end if - productID
	
	if(name.value.length <4 || name.value.length>12){
		alert("[상품명]\n최소 4자에서 최대 12자까지 입력할 수 있습니다.");
		name.focus();
		return false;
	} // end if - name
	
	if(unitPrice.value.length == 0 || inNaN(unitPrice.value)){
		alert("[가격]\n 숫자만 입력하세요.");
		unitPrice.focus();
		return false;
	} // end if - unitPrice
	
	if(isNaN(unitsInStock.vlaue)){
		alert("[재고]\n 숫자만 입력하세요.");
		unitsInStock.focus();
		return false;
	} // end if - unitsInStock
	
	document.newProduct.submit();
}