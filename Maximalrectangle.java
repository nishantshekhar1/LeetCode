import java.util.Stack;

public class Maximalrectangle {


    private static int maxAreaInHist(int[] height){

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int max = 0;

        while(i < height.length){
            if(stack.isEmpty() || height[stack.peek()] <= height[i]){
                stack.push(i++);
            }else{
                int t = stack.pop();
                max = Math.max(max,height[t]*(stack.isEmpty() ? i : i - stack.peek() -1 ));
            }
        }

        return max;
    }


    public static int maximalRexctangle(char[][] matrix) {

        int m = matrix.length;
        int n = m == 0? 0 : matrix[0].length;
        int[][] height = new int[m][n+1];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if(matrix[i][j] == '1') {
                    height[i][j] = i == 0 ? 1: height[i-1][j] + 1;

                }else{
                    height[i][j] = 0;
                }
            }
        }

        for(int i= 0; i < m ; i++){
            int area = maxAreaInHist(height[i]);
            if(area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }


    public static void main(String args[]) {


        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int result = maximalRexctangle(matrix);

        System.out.println(result);

    }
}
