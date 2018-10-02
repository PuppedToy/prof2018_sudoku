package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	
	private int[] values;
	
	public SudokuVerifier() {
		this.values = null;
	}
	
	public int verify (String candidateSolution)
    {
		String[] string_values = candidateSolution.split("");
		if(string_values.length != 81) return -1;
		
		values = new int[81];
		for(int i = 0; i < values.length; i++) {
			values[i] = Integer.parseInt(string_values[i]);
		}
		
		if(!validateCells()) return -1;
		
		try {
			
			for(int i = 0; i < 9; i++) {
				if(!validateGroup(getQuadrant(i))) return -2;
			}
			for(int i = 0; i < 9; i++) {
				if(!validateGroup(getRow(i))) return -3;
			}
			for(int i = 0; i < 9; i++) {
				if(!validateGroup(getColumn(i))) return -4;
			}
		} catch (InvalidIndexException e) {
			e.printStackTrace();
			return -1;
		}
		
        return 0;
    }
	
	public int[] getColumn(int index) throws InvalidIndexException {
		if(index < 0 || index > 8) throw new InvalidIndexException("Column index expected between 1 and 9");
		
		int[] res = new int[9];
		int res_index = 0;
		for(int i = index; i < 81; i += 9) {
			res[res_index++] = values[i];
		}
		
		return res;
	}
	
	public int[] getRow(int index) throws InvalidIndexException {
		if(index < 0 || index > 8) throw new InvalidIndexException("Row index expected between 1 and 9");
		
		int[] res = new int[9];
		int res_index = 0;
		for(int i = index * 9; i < index*9+9; i++) {
			res[res_index++] = values[i];
		}
		
		return res;
	}
	
	public int[] getQuadrant(int index) throws InvalidIndexException {
		if(index < 0 || index > 8) throw new InvalidIndexException("Quadrant index expected between 1 and 9");
		
		int[] res = new int[9];
		int res_index = 0;
		for(int i = getQuadrantIndex(index); res_index < 9; i++) {
			res[res_index++] = values[i];
			if(res_index%3 == 0) i += 6;
		}
		
		return res;
	}
	
	public boolean validate() {
		
		boolean res = true;
		
		try {
			
			for(int i = 0; res && i < 9; i++) {
				res = res && validateGroup(getColumn(i));
				res = res && validateGroup(getRow(i));
				res = res && validateGroup(getQuadrant(i));
			}
			
		} catch (InvalidIndexException e) {
			e.printStackTrace();
			return false;
		}
		
		return res;
	}
	
	public boolean validateGroup(int[] group) {
		boolean[] validatorList = new boolean[9];
		
		for(int i = 0; i < 9; i++) {
			if(validatorList[group[i] - 1]) return false;
			validatorList[group[i] - 1] = true;
		}
		
		return true;
	}
	
	public boolean validateCells() {
		for(int value : values) {
			if(value < 1 || value > 9) return false;
		}
		return true;
	}
	
	private int getQuadrantIndex(int index) {
		
		return (index/3)*27 + (index%3*3);
	}
	
}
