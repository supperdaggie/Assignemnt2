import java.util.ArrayList;


public class Notation {
	

	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException  {
		MyQueue<Character> mq = new MyQueue<Character>(infix.length());
		MyStack<Character> ms = new MyStack<Character>(infix.length());
		String result = "";
		boolean found = false;


		try {

			for(int i = 0; i < infix.length(); i++) {
				char curr = infix.charAt(i);

				if(curr == ' ') {
					continue;
				}
				if(Character.isDigit(curr)) {
					mq.enqueue(curr);

				}
				if(curr == '(') {
					ms.push(curr);
				}

				if(curr == '+' || curr =='-' ||curr == '*'|| curr =='/') {
					char c = (char) ms.top();


					if (c == '/' && (curr == '/' ||curr =='*'|| curr == '+' || curr =='-')){
						mq.enqueue(ms.pop());
					}
					if(c == '*' && (curr == '/'||curr == '*' ||curr == '+' || curr =='-')) {
						mq.enqueue(ms.pop());
					}
					if(c == '+' && (curr == '+' ||curr == '-')) {
						mq.enqueue(ms.pop());
					}
					if(c == '-' && (curr == '+' ||curr == '-')) {
						mq.enqueue(ms.pop());
					}

					ms.push(curr);

				}

				if(curr == ')') {

					found =  false;

					while(ms.size() > 0) {
						char c = (char) ms.pop();

						//	System.out.print(mq.dequeue());

						if(c == '(' ) {
							found = true;
							break;

						}
						mq.enqueue(c);
						//result+=(mq.dequeue()); 
					}	


				}

			}

			if(ms.size() != 0) {
				for(int i4 = 0; i4 < ms.size(); i4++) {
					mq.enqueue(ms.pop());
				}
			}

			while(mq.size()>0) {
				result += mq.dequeue();
			}

			if(!found) { throw new InvalidNotationFormatException();}
			return result;

		}
		catch(Exception e) {
			e.getMessage();
			return result;
		}
	}

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyQueue<Object> mq = new MyQueue<Object>(postfix.length());
		MyStack<Object> ms = new MyStack<Object>(postfix.length());
		String result = "";

		try {
			for(int indx = 0; indx< postfix.length(); indx++) {
				char curr = postfix.charAt(indx);

				if(curr == ' ') {
					continue;
				}
				if(Character.isDigit(curr)) {
					ms.push(curr);
				}
				if(curr == '+' || curr =='-' ||curr == '*'|| curr =='/') {

					if(ms.size() == 1) {
						throw new InvalidNotationFormatException();
					}
					String data = "";

					Object c1 = ms.pop();
					Object c2 = ms.pop();
					data += "(" + c2 + curr + c1 + ")";
					ms.push(data);	
				}
			}

			if(ms.size() > 1) {
				throw new InvalidNotationFormatException();
			}

			result += ms.top();
			return result;
		}
		catch(Exception e) {
			e.getMessage();
			return result;
		}

	}

	public static  double evaluatePostfixExpression(String postfixExpr)  throws InvalidNotationFormatException {
		MyStack<Integer> ms = new MyStack<Integer>(postfixExpr.length());
		double result = 0.0;
		try {

			for(int indx = 0; indx< postfixExpr.length(); indx++) {
				char curr = postfixExpr.charAt(indx);

				if(curr == ' ') {
					continue;
				}

				if(Character.isDigit(curr) ) {
					int copy = Character.getNumericValue(curr);
					ms.push(copy);
				}

				if(curr == '+' || curr =='-' ||curr == '*'|| curr =='/') {
					int count = 0;
					int c =  (int) ms.pop();
					int c2 = (int) ms.pop();

					if(curr == '+') {
						count = c + c2;
						ms.push(count);
					}
					else if(curr == '-') {
						count = c - c2;
						ms.push(count);
					}
					else if(curr == '*') {
						count = c * c2;
						ms.push(count);
					}
					else if(curr == '/') {
						count = c / c2;
						ms.push(count);
					}

				}

			}

			if(ms.size() > 1) {
				throw new InvalidNotationFormatException();
			}


			int copy = (int) ms.pop();
			result = copy;
			return result;
		}
		catch(Exception e) {
			e.getMessage();
			return result;
		}

	}

}




