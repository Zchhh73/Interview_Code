package yuan_code;

import java.util.ArrayList;
import java.util.List;

/**
 *  5.二维数组回行打印
 */
public class Question005 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return res;
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(true){
            for(int col = left;col<=right;col++){
                res.add(matrix[top][col]);
            }
            top++;
            if(top >bottom) break;

            for(int row = top;row<=bottom;row++){
                res.add(matrix[row][right]);
            }
            right--;
            if(left > right) break;

            for(int col = right;col>=left;col--){
                res.add(matrix[bottom][col]);
            }
            bottom--;
            if(top > bottom) break;

            for(int row = bottom;row >= top ;row--){
                res.add(matrix[row][left]);
            }
            left++;
            if(left > right) break;
        }
        return res;
    }
}
