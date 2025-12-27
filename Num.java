public class Num{
public static void main(String args[]){
int n=7789;
int lastdigits=0;
while(n>0){
lastdigits=n%10;
n=n/10;
System.out.println("lastdigits:" + lastdigits);
}
}
}