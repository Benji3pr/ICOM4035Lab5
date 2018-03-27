package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		if(s.length()%2!=0){
			return false;
		}
		SLLStack<Character> stack = new SLLStack<Character>();
		for(int i = 0; i<s.length(); i++){
			Character c = s.charAt(i);
			if(Character.isLetter(c)){
				 if(Character.isUpperCase(c)){
					 stack.push(c);
				 }
				 else if(stack.isEmpty()){
					 return false;
				 }
				 else{
					 char t = stack.top();
					 if(t == Character.toUpperCase(c)){
						 stack.pop();
					 }
					 else return false;
				 }
				 
			}
			else
				return false;
		}
		
		return true;  
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		if(!this.isValidContent()){
			throw new StringIsNotSymmetricException("The string is not symmetric");
		}
		String ps = new String();
		String ts = new String();
		for(int i = 0; i<s.length(); i++){
			Character c = s.charAt(i);
			if(Character.isUpperCase(c)){
				ts = ("<"+c+" ");
			}
			else if(Character.isLowerCase(c)){
				ts = (c+"> ");
			}
			ps = ps+ts;
		}
		
		
		return ps;
	}

}
