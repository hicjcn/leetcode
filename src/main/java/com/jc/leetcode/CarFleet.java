package com.jc.leetcode;

/**
 * 车队
 *
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 *
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 *
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 *
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 *
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 *
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 *
 *  
 *
 * 会有多少车队到达目的地?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/car-fleet
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/11/5
 */
public class CarFleet {
    public static void main(String[] args) {
        int[] position = new int[]{6,8};
        int[] speed = new int[]{3,2};
        System.out.println(carFleet(10,position,speed));
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        if (target == 0){
            return position.length;
        }
        // 排序 排索引位置
        int[] indexDesc = new int[position.length];
        for (int i = 0; i < indexDesc.length; i++) {
            indexDesc[i] = i;
        }
        for(int i=0; i<position.length-1; i++){
            for(int j=0; j<position.length-1-i; j++)
            {
                if(position[indexDesc[j]]<position[indexDesc[j+1]])
                {
                    int k=indexDesc[j];
                    indexDesc[j]=indexDesc[j+1];
                    indexDesc[j+1]=k;
                }
            }
        }
        // 计算车队
        int carFleetCnt = 0;
        double lastneeds = -1;
        for (int i = 0; i < position.length; i++) {
            double curneeds = (target - position[indexDesc[i]]) / 1.0 / speed[indexDesc[i]];
            if (lastneeds < 0 || curneeds > lastneeds){
                lastneeds = curneeds;
                carFleetCnt++;
            }
        }
        return carFleetCnt;
    }
}
