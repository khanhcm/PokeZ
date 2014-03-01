package android.at.pokez;

import java.util.Random;

public class GameMatrix {
	int _rows;
	int _cols;
	int[][] matrix;
	
	public int get_rows() {
		return _rows;
	}

	public void set_rows(int _rows) {
		this._rows = _rows;
	}

	public int get_cols() {
		return _cols;
	}

	public void set_cols(int _cols) {
		this._cols = _cols;
	}

	public int[][] getMatrix() {
		return matrix;
	}


	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public GameMatrix(int row, int col){
		_rows = row;
		_cols = col;
		matrix = new int[row][col]; 
		for (int i = 0; i < _rows; i++)
			for (int j = 0; j < _cols; j++)
				matrix[i][j] = 0;
	}
	
	public void generateMatrix(){
		int temp;
		Random random = new Random();
		int test = 0;//biến đếm số lần giống nhau của các số
		for (int i = 0; i < _rows; i++)
		{
			test=0;
			for (int j = 0; j < _cols; j++) {
				do {
					test = 0;
					temp = 1 + random.nextInt(20);
					for (int e = 0; e < _rows; e++)
						for (int f = 0; f < _cols; f++)
							if (matrix[e][f] == temp)
								test++;
					//System.out.print(test+" "+"");
				} while (test >= 2);
				matrix[i][j] = temp;
				test = 0;
			}
		}
	}
	
}
