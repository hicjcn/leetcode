package com.jc.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 账号合并
 *
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 *
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 *
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 *
 * 例子 1:
 *
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 *   第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
 *   第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 *   我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 *   ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 *
 * 注意：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 *
 * [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],
 * ["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]
 *
 * [["Hanzo","Hanzo2@m.co","Hanzo3@m.co"],["Hanzo","Hanzo4@m.co","Hanzo5@m.co"],
 * ["Hanzo","Hanzo0@m.co","Hanzo1@m.co"],["Hanzo","Hanzo3@m.co","Hanzo4@m.co"],
 * ["Hanzo","Hanzo7@m.co","Hanzo8@m.co"],["Hanzo","Hanzo1@m.co","Hanzo2@m.co"],
 * ["Hanzo","Hanzo6@m.co","Hanzo7@m.co"],["Hanzo","Hanzo5@m.co","Hanzo6@m.co"]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenjian on 2019/12/3
 */
public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            List<String> mail = new ArrayList<>();
            switch (i){
                case 0:
                    mail.add("David");
                    mail.add("David2");
                    mail.add("David3");
                    break;
                case 1:
                    mail.add("David");
                    mail.add("David4");
                    mail.add("David5");
                    break;
                case 2:
                    mail.add("David");
                    mail.add("David0");
                    mail.add("David1");
                    break;
                case 3:
                    mail.add("David");
                    mail.add("David4");
                    mail.add("David3");
                    break;
                case 4:
                    mail.add("David");
                    mail.add("David7");
                    mail.add("David8");
                    break;
                case 5:
                    mail.add("David");
                    mail.add("David1");
                    mail.add("David2");
                    break;
                case 6:
                    mail.add("David");
                    mail.add("David6");
                    mail.add("David7");
                    break;
                case 7:
                    mail.add("David");
                    mail.add("David5");
                    mail.add("David6");
                    break;
            }
            lists.add(mail);
        }
        accountsMerge(lists);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mailMap = new HashMap<>();
        List<List<String>> accountsMergeList = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            Integer currMergeIndex = -1;
            List<Integer> oldIndex = new ArrayList<>();
            List<String> account = accounts.get(i);
            List<String> accountMerge = new ArrayList<>();
            for (int j = 1; j < account.size(); j++) {
                if (mailMap.containsKey(account.get(j))){
                    //找出原来的账号
                    oldIndex.add(mailMap.get(account.get(j)));
                }
                accountMerge.add(account.get(j));
            }
            oldIndex = oldIndex.stream().distinct().sorted(Integer::compareTo).collect(Collectors.toList());
            if (oldIndex.size() > 0){
                currMergeIndex = oldIndex.get(0);
                for (int j = 1; j < oldIndex.size(); j++) {
                    int index = oldIndex.get(j);
                    List<String> temp = accountsMergeList.get(index);
                    // 移除第一个
                    temp.remove(0);
                    // 移除合并
                    accountMerge.addAll(temp);
                }
                accountsMergeList.get(currMergeIndex).addAll(accountMerge);
            } else {
                currMergeIndex = accountsMergeList.size();
                List<String> finAccountMerge = new ArrayList<>();
                finAccountMerge.add(account.get(0));
                finAccountMerge.addAll(accountMerge);
                accountsMergeList.add(finAccountMerge);
            }
            for (int j = 0; j < accountMerge.size(); j++) {
                mailMap.put(accountMerge.get(j),currMergeIndex);
            }
            for (int j = 1; j < oldIndex.size(); j++) {
                int index = oldIndex.get(j);
                accountsMergeList.remove(index - j + 1);
                mailMap.forEach((k,v) -> {
                    if (v > index){
                        mailMap.put(k, v - 1);
                    }
                });
            }
        }
        for (int i = 0; i < accountsMergeList.size(); i++) {
            accountsMergeList.set(i,
                    accountsMergeList.get(i).
                            stream().
                            distinct().
                            sorted(String::compareTo).
                            collect(Collectors.toList()));
        }
        return accountsMergeList;
    }

    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> emailToName = new HashMap();
            Map<String, ArrayList<String>> graph = new HashMap();
            for (List<String> account: accounts) {
                String name = "";
                for (String email: account) {
                    if (name == "") {
                        name = email;
                        continue;
                    }
                    graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                    graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                    emailToName.put(email, name);
                }
            }

            Set<String> seen = new HashSet();
            List<List<String>> ans = new ArrayList();
            for (String email: graph.keySet()) {
                if (!seen.contains(email)) {
                    seen.add(email);
                    Stack<String> stack = new Stack();
                    stack.push(email);
                    List<String> component = new ArrayList();
                    while (!stack.empty()) {
                        String node = stack.pop();
                        component.add(node);
                        for (String nei: graph.get(node)) {
                            if (!seen.contains(nei)) {
                                seen.add(nei);
                                stack.push(nei);
                            }
                        }
                    }
                    Collections.sort(component);
                    component.add(0, emailToName.get(email));
                    ans.add(component);
                }
            }
            return ans;
        }
    }
}
