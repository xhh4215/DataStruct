public class Main {
    public static void main(String[] args){
        System.out.println("你好呀");
        Array<Integer> array  =  new Array();
        for(int i  = 0;i<10;i++){
            array.addLast(i);
            System.out.println(array);
        }
        array.add(1,32);
        System.out.println(array);

    }
}
