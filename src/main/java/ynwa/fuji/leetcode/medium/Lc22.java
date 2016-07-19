package ynwa.fuji.leetcode.medium;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ynwa on 16/7/18.
 * https://leetcode.com/problems/generate-parentheses/
 * TODO https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Lc22 {
    public static void main(String[] args) {
        Lc22 l = new Lc22();
//        List<String> x = l.generateParenthesis(3);
        List<String> x = l.generateParenthesis1(3);
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    public void generateOneByOne(String sublist, List<String> list, int left, int right){
//        System.out.printf("left={},right={} \r\n",left,right);
        System.out.println("left="+left + ",right="+right);
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }

    public List<String> generateParenthesis1(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }
}
