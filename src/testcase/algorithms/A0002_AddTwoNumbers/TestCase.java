package testcase.algorithms.A0002_AddTwoNumbers;

import problems.algorithms.A0002_AddTwoNumbers.ListNode;
import problems.algorithms.A0002_AddTwoNumbers.Solution;

import java.util.Objects;

/**
 * A002_AddTwoNumbers
 *
 * @author steven.zmj
 * @date 2020/12/05
 */
public class TestCase {

    public static void main(String[] args) {
        test("5", "5", "10");
        test("342", "465", "807");
        test("9999", "9999999", "10009998");
    }

    private static void test(String a, String b, String expectedResult) {
        final Solution solution = new Solution();
        final ListNode listNode = solution.addTwoNumbers(genListNode(a), genListNode(b));
        final String actualResult = parseListNodeReverse(listNode);
        System.out.println(String.format("param1: %s, param2: %s, ", a, b) + (Objects.equals(expectedResult, actualResult) ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }

    private static ListNode genListNode(String input) {
        final ListNode startNode = new ListNode(0);
        ListNode currNode = startNode;

        for (int i = 0; i < input.length(); i++) {
            currNode.next = new ListNode(Character.getNumericValue(input.charAt(i)));
            currNode = currNode.next;
        }

        return startNode.next;
    }

    private static String parseListNodeReverse(ListNode input) {
        final StringBuilder sb = new StringBuilder();
        while (input != null) {
            sb.append(input.val);
            input = input.next;
        }
        return sb.reverse().toString();
    }
}
