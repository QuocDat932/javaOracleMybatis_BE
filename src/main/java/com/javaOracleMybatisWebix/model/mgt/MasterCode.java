package com.javaOracleMybatisWebix.model.mgt;

public class MasterCode {
	
	public enum invalidMgt{
		IVL_NAME("InvalidName"),
		INV_ROLE("InvalidRole"),
		NEW_RECORD("NewRecord");
		private String code;
		
		invalidMgt(String newCode){
			this.code = newCode;
		};
		
		public String getCode() {
			return this.code;
		}
	}
}
