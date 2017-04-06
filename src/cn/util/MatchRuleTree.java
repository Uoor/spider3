package cn.util;

/**
 * Created by uoor on 4/6/17.
 */
/*

规则：
1. 1,3,4 道路名 + 住宅小区 + 牌楼号
2. 1,2   道路名 + 门楼号
3. 1,4   道路名 + 牌楼号
4. 1,5   道路名 + 建筑物
5. 3,4   住宅校区名 + 楼牌号
6. 5     建筑物 
*/

class TreeNode {

    int val;
    TreeNode left1;
    TreeNode left2;
    TreeNode right1;
    TreeNode right2;
    TreeNode(int x) { val = x; }

 }

public class MatchRuleTree {

}
