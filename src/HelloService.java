public class HelloService {	
	public String sayHello(){
		return "hello";
	}	
	public String sayHelloToPerson(String name){		
		if(name==null){
			name = "nobody";
		}
		return "hello,"+name;
	}
	public void updateData(String data){
		System.out.println(data+" 已更新。 ");
	}
	
}