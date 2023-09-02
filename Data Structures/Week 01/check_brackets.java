import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        short error_occured = 0;
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(new Bracket(next , position));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (!opening_brackets_stack.isEmpty()) {
                    if (opening_brackets_stack.peek().Match(next)) {
                        opening_brackets_stack.pop();
                    } else {
                        error_occured = 1;
                        System.out.println(position + 1);
                        break;
                    }
                }else {
                    error_occured = 1;
                    System.out.println(position + 1);
                    break;
                }
            }
        }

        // Printing answer, write your code here
        if (opening_brackets_stack.isEmpty() && error_occured == 0){
            System.out.println("Success");
        }else if (!opening_brackets_stack.isEmpty() && error_occured == 0){
            System.out.println(opening_brackets_stack.elementAt(0).position + 1);
        }
    }
}
