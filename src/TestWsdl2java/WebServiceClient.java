package TestWsdl2java;

import java.rmi.RemoteException;

public class WebServiceClient {

	/**
	 * 使用axis2命令 wsdl2java自动生成程序的调用模式
	 * @param args
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws RemoteException {
		HelloServiceNewStub stub = new HelloServiceNewStub();
		
		
		
		//方法，输入参数，返回值
		HelloServiceNewStub.SayHelloToPerson gg = new HelloServiceNewStub.SayHelloToPerson();
		gg.setArgs0("美女");
		String reVal2 = stub.sayHelloToPerson(gg).get_return();
		System.out.println(reVal2);
		
		//方法，返回值 :传入值为空
		HelloServiceNewStub.SayHello ss = new HelloServiceNewStub.SayHello();
		String reVal = stub.sayHello(ss).get_return();
		System.out.println(reVal);
		
		//方法，输入参数：函数 invokeRobust
		//在tomcat的后台能看到
		HelloServiceNewStub.UpdateData uu = new HelloServiceNewStub.UpdateData();
		uu.setArgs0("美女updateData");
		stub.updateData(uu);
		
	}
}
