package utils;

public final class Mat {
	
	public Mat() {}
	
	private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
	    double cell = 0;
	    for (int i = 0; i < secondMatrix.length; i++) {
	        cell += firstMatrix[row][i] * secondMatrix[i][col];
	    }
	    return cell;
	}
	
	public static double[][] multiplyMatrix(double coef, double[][] matrix) {
		double[][] result = new double[matrix.length][matrix[0].length];
		
		for (int row = 0; row < result.length; row++) {
	        for (int col = 0; col < result[row].length; col++) {
	            result[row][col] = coef * matrix[row][col];
	        }
	    }
		return result;
	}
	
	public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

	    for (int row = 0; row < result.length; row++) {
	        for (int col = 0; col < result[row].length; col++) {
	            result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
	        }
	    }
	    return result;
	}
	
	public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix, double coef) {
		double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

	    for (int row = 0; row < result.length; row++) {
	        for (int col = 0; col < result[row].length; col++) {
	            result[row][col] =  coef * multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
	        }
	    }
	    return result;
	}
	
	public static double[] incrementVector(double offset , double[] vect){
		double[] result = new double[vect.length];
		
		for (int row = 0; row < vect.length; row++) {
			result[row] = offset + vect[row];
	    }
		return result;
	}
	
	public static double[] multiplyVector(double coef , double[] vect){
		double[] result = new double[vect.length];
		
		for (int row = 0; row < vect.length; row++) {
			result[row] = coef * vect[row];
	    }
		return result;
	}
	
	public static double[] offsetVector(double[] offset , double[] vect){
		double[] result = new double[vect.length];
		
		for (int row = 0; row < result.length; row++) {
			result[row] = offset[row] + vect[row];
	    }
		return result;
	}
	
	
	public static int[][] roundMatrix(double[][] mat){
		int res[][] = new int[mat.length][mat[0].length];
		for(int row=0;row<res.length;row++){
			for(int col=0;col<res[0].length;col++) {
				res[row][col]=(int)Math.round(mat[row][col]);
			}
		}
		return res;
	}
	
	public static int[] roundVector(double[] vect){
		int res[] = new int[vect.length];
		for(int row=0;row<res.length;row++){
			res[row]=(int)Math.round(vect[row]);
		}
		return res;
	}
	
	public static double[][] offsetVertices(int[] offset, double[][] verticesMat){
		double[][] res = new double[verticesMat.length][verticesMat[0].length];
		for(int row=0;row<res.length;row++){
			for(int col=0;col<res[0].length;col++) {
				res[row][col]=verticesMat[row][col] + offset[row];
			}
		}
		return res;
	}
	
	public static double[][] multiplyVec(double[] vector, double[][] mat){
		double[][] res = new double[mat.length][mat[0].length];
		for(int row=0;row<res.length;row++){
			for(int col=0;col<res[0].length;col++) {
				res[row][col]=mat[row][col] * vector[row];
			}
		}
		return res;
	}
	
}
