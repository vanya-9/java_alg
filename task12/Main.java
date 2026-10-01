package task12;

public class Main{

    public static String normalize(char[] str){
        int write = 0;
        int read = 0;

        while(read < str.length && str[read] == ' '){
            read++;
        }

        while(read < str.length){
            str[write] = str[read];
            write++;
            read++;
            while(read < str.length && str[read] == ' ' && str[read - 1] == ' '){
                read++;
            }
        }

        while(write > 0 && str[write - 1] == ' '){
            write--;
        }
        return new String(str, 0, write);
    }
    public static void main(String[] args){
        char[] test = {' ',' ','s', 'o', 'm', 'e', ' ', ' ', ' ', 's', 't', ' ', ' ', ' ','r', 'i', 'n', ' ', ' '};
        System.out.println(normalize(test) + " endw");
    }
}
// some    string -> some string
// some  s