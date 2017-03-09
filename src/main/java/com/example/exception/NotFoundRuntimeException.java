package com.example.exception;

//에러 처리 객체를 만든다. 에러를 나타냄. notfound 그니까 없을 때 사용하는 객체. 
//익셉션 객체가 되려면 익셉션 객체를 extends해야함. 
public class NotFoundRuntimeException extends RuntimeException{

	public NotFoundRuntimeException() {
		
			}
	
	public NotFoundRuntimeException(String msg) {
		super(msg);
	}
}
