package TestClient;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.rpc.client.RPCServiceClient;


public class WebServiceClient {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws AxisFault{
		
		String url = "";
		String targetNamespace = "";
		
//		targetNamespace的确定用浏览器查看：  http://localhost:8888/axis2/services/HelloService?wsdl 的targetNamespace
//		targetNamespace = "http://ws.apache.org/axis2";
//		url = "http://localhost:8888/axis2/services/HelloService";
		
//		查看：http://localhost:8888/axis2/services/HelloServiceNew?wsdl 的targetNamespace
//		targetNamespace = "http://webservice.techstar.com";
//		url = "http://localhost:8888/axis2/services/HelloServiceNew";
//		
//		查看：http://localhost:8888/axis2/services/HelloServiceNewCope?wsdl 的targetNamespace
		targetNamespace = "http://webservice.techstar.com";
		url = "http://localhost:8888/axis2/services/HelloServiceNewCope";
		
		
		//1.WebService : 使用RPC方式调用Webservice
		RPCServiceClient serviceClient = new RPCServiceClient();
		//2.url : 指定抵用WebService的URL
		serviceClient.getOptions().setTo(new EndpointReference(url));
		
		//3.WSDL和方法 : 指定调用方法以及WSDL文件的命名空间 
		QName opAddEntry = null;
		//4.输入参数 ：指定调用方法的参数值
		Object[] opAddEntryArgs = null;
		//5.返回值 : 指定调用方法的返回值的数据类型的Class对象
		Class[] returnTypes = null;
		
		
		//方法，输入参数，返回值
		opAddEntry = new QName(targetNamespace, "sayHelloToPerson");
		opAddEntryArgs = new Object[]{"美女"};
		returnTypes = new Class[]{String.class};
		Object[] reVal = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs,returnTypes); 
		System.out.println(reVal[0]);
		
		//方法，返回值 :传入值为空
		opAddEntry = new QName(targetNamespace,"sayHello");
		opAddEntryArgs = new Object[]{};
		returnTypes = new Class[]{String.class};
		reVal = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, returnTypes);
		System.out.println(reVal[0]);

		//方法，输入参数：函数 invokeRobust
		//在tomcat的后台能看到
		opAddEntry = new QName(targetNamespace,"updateData");
		opAddEntryArgs = new Object[]{"美女DATA"};
		serviceClient.invokeRobust(opAddEntry, opAddEntryArgs);
		
	}
}


