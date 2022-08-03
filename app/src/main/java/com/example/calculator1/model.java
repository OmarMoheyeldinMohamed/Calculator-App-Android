package com.example.calculator1;
enum Operation {not_set, modulus, divide, multiply, minus, plus}
public class model {
    private String first_num, second_num, result;
    private char first_sign, second_sign;
    private Operation op;
    private double first_db, second_db, result_db;
    private boolean first_done, result_done;

    public model()
    {
        first_num = second_num = "";
        first_db = second_db = 0.0;
        first_done = false;
        op = Operation.not_set;
        first_sign = second_sign = '+';
        result_done = false;
    }


    public String getFirst_num()
    {
        return first_num;
    }
    public String getSecond_num()
    {
        return second_num;
    }
    public String get_what_to_write()
    {
        String res = "";
        if (first_done == false)
        {
            if (first_sign == '-')
                res = first_sign + first_num;
            else
                res = first_num;

        }
        else if (result_done == false)
        {
            if (second_sign == '-')
                res = second_sign + second_num;
            else
                res = second_num;
        }
        else
        {
            res = result;

        }
        if (res.equals("") == false)
        {
            double x = Double.parseDouble(res);
            res = String.valueOf(x);
        }

        if (res.length() >8 && res.equals("") == false)
        {
            boolean flag = false;
            for (int i = 0; i < res.length(); i++)
            {
                if (res.charAt(i) == 'E')
                    flag = true;

            }
            if (flag == false)
            {
                String temp = res;
                res = "";
                int i = 0;
                flag = false;
                while (i<8 || flag == false)
                {
                    res = res + temp.charAt(i);
                    if (temp.charAt(i) == '.')
                        flag = true;
                    i++;
                }

            }
            else
            {
                String exponent = "";
                flag = false;
                for (int i = 0; i < res.length(); i++)
                {
                    if (flag == true)
                        exponent = exponent + res.charAt(i);
                    else
                    {
                        if (res.charAt(i) == 'E')
                        {
                            flag  = true;
                            exponent = exponent + res.charAt(i);
                        }
                    }
                }
                String temp = res;
                res = "";
                int i = 0;
                while (i+exponent.length()<8 )
                {
                    res = res  + temp.charAt(i);
                    i++;
                }
                res = res + exponent;
            }


        }
        return  res;

    }
    public void getbutton(char x)
    {
        if (x == '0')
        {
            if (first_done == true)
            {
                if (second_num.length()==1)
                {
                    if(second_num.charAt(0) == '0')
                    {

                    }
                    else
                    {
                        second_num = second_num + '0';
                    }
                }
                else
                    second_num = second_num + '0';
            }
            else
            {
                if (first_num.length()==1)
                {
                    if(first_num.charAt(0) == '0')
                    {

                    }
                    else
                    {
                        first_num = first_num + '0';
                    }
                }
                else
                    first_num = first_num + '0';
            }
        }
        else if (x == '1' || x == '2' || x == '3' || x == '4' || x == '5'
                || x == '6' || x == '7' || x == '8' || x == '9')
        {
            if (first_done == true)
            {
                second_num = second_num + x;

            }
            else
                first_num = first_num + x;
        }
        else if (x == 'C')
        {
            first_num = second_num = result = "";
            first_db = second_db = result_db =  0.0;
            op = Operation.not_set;
            first_done = false;
            first_sign = second_sign = '+';
            result_done = false;
        }
        else if(x == '~')
        {
            if (first_done == true)
            {
                if (second_sign == '+')
                    second_sign = '-';
                else
                    second_sign = '+';

            }
            else
            {
                if (first_sign == '+')
                    first_sign = '-';
                else
                    first_sign = '+';
            }
        }
        else if(x == '%'|| x == '/' || x == 'X' || x == '-' || x == '+' )
        {
            switch (x)
            {
                case '%': op = Operation.modulus;
                break;
                case '/': op = Operation.divide;
                break;
                case 'X': op = Operation.multiply;
                break;
                case '-': op = Operation.minus;
                break;
                case '+': op = Operation.plus;
                break;

            }
            if (result_done == true)
            {
                if (result_db > 0)
                {
                    first_num = result;
                    first_db = result_db;
                    first_sign = '+';
                    result_done = false;
                    result = "";
                    result_db = 0;
                }
                else
                {
                    first_db =  result_db;
                    result_db = 0;
                    result = "";
                    first_num = String.valueOf(result_db);
                    first_sign = '-';
                    result_done = false;

                }
                second_num = "";
                second_db = 0;
                second_sign = '+';
                first_done = true;
            }
            else
            {
                if (!first_num.equals(""))
                {
                    first_db = Double.parseDouble(first_num);
                    if (first_sign == '-')
                        first_db = 0-first_db;
                    first_done = true;
                }
            }

            
        }
        else if (x == '.')
        {
            boolean flag = false;
            if (first_done == true)
            {
                for (int i = 0; i < second_num.length(); i++)
                {
                    if (second_num.charAt(i) == '.')
                        flag = true;

                }
                if (flag == false)
                    second_num = second_num + '.';
            }
            else
            {
                for (int i = 0; i < first_num.length(); i++)
                {
                    if (first_num.charAt(i) == '.')
                        flag = true;

                }
                if (flag == false)
                    first_num = first_num + '.';
            }
        }
        else if (x == '=')
        {
            second_db = Double.parseDouble(second_num);
            if (second_sign == '-')
                second_db = 0 - second_db;
            switch (op)
            {
                case modulus: result_db = first_db % second_db;
                break;
                case divide: result_db = first_db / second_db;
                break;
                case multiply: result_db = first_db * second_db;
                break;
                case minus: result_db = first_db - second_db;
                break;
                case plus: result_db = first_db + second_db;
                break;
            }
            result = String.valueOf(result_db);
            result_done = true;
        }
    }
}
