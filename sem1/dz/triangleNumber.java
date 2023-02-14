class triangleNumber{
    public static void main(String[] args){
        // здесь сценарий выдачи n-ого числа введенного с клавиатуры
        Integer order = Integer.valueOf(input.input_("Which by order?"));
        Integer out = math_part(order);
        System.out.println(out);
        toFile.write_("out.txt",out.toString());

    }
    public static Integer math_part(Integer n){
        Double tmp = n.doubleValue()/2;
        Integer out = (int)(tmp*(n+1));

        return out;
    }
    {


    }
}