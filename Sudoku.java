public class Sudoku{

	void displayGrid(String[][] arr){
		int line, symbols, size = arr.length, row = 0, column = 0;
		String dash;
		if(size > 9){
			dash = "----";
		} else {
			dash = "---";
		}
		for(line = 1; line <= 2*size+1; line++){
			if(line % 2 == 1){
				System.out.print("+");
				for(symbols = 2*size-1; symbols > 0; symbols--){
					if(symbols % 2 == 1){
						System.out.print(dash);
					} else {
						System.out.print("+");
					}
				}
				System.out.print("+");
			} else {
				for(symbols = 2*size+1; symbols > 0; symbols--){
					if(symbols % 2 == 1){
						System.out.print("|");
					} else {
						String value = String.valueOf(arr[row][column++]);
                        System.out.print(" "+ value +" ");
                        if(column >= size){
                            row++;
                            column = 0;
                        }
					}
				}
			}
			System.out.println();
		}
	}
	
	String[][] getArray(int size){
        String[][] arr = new String[size][size];
        for(int i = 0; i < size; i++){
            arr[0][i] = String.valueOf(i + 1);
        }
        for(int i = 1; i < size - 1; i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = arr[i - 1][(j + 1) % size];
            }
        }
        for(int i = 0; i < size; i++){
            arr[size - 1][i] = arr[0][size - 1 - i];
        }
        return arr;
    }
    
    void setEmptyBlocks(String[][] layout){
        int row, column, size = layout.length;
        int emptyBlocks = (size*size)/3;
        for(int i = 0; i < emptyBlocks; i++) {
            row = (int)(System.nanoTime()/100 % size); 
            column = (int)(System.nanoTime()/500 % size);
            layout[row][column] = " ";
        }

    }
	
	public static void main(String[] args){
		Sudoku s = new Sudoku();
		int size = Integer.parseInt(args[0]);
		String[][] layout = s.getArray(size);
		s.setEmptyBlocks(layout);
		s.displayGrid(layout);
	}
}
