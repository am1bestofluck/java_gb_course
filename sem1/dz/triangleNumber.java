class triangleNumber{
    public static void main(String[] args){
        // здесь сценарий выдачи n-ого числа введенного с клавиатуры
        Integer order = Integer.valueOf(input.input_("Which by order?"));
        System.out.println(math_part(order));

    }
    public static Integer math_part(Integer n){
        return n/2*(n+1);
    }
    {


    }
}