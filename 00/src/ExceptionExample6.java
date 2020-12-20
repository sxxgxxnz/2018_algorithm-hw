public class ExceptionExample6 {
public static void main(String args[]) {
try {
	int result = subtract(5, 100);
	System.out.println(result);
}
catch (InvalidInputException e) {
	System.err.println(e.getMessage());
}
}
	static int subtract(int a, int b)
		throws InvalidInputException {
if (a < b)
throw new InvalidInputException();
return a - b;
}
}
class InvalidInputException extends Exception {
InvalidInputException() { // 생성자
super("잘못된 입력입니다.");
}
}
