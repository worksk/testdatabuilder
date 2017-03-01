package cn.datainfo.ot.databuild;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class CreateRandomInt {

	public int createInt() {
		int _int = 0;
		Random r = new Random();
        _int = r.nextInt(1000);
		
		return _int;
	}
	
	public String createDate(){  
	       Calendar calendar = Calendar.getInstance();  
	       //注意月份要减去1  
	       calendar.set(1990,11,31);  
	       calendar.getTime().getTime();  
	       //根据需求，这里要将时分秒设置为0  
	       calendar.set(Calendar.HOUR_OF_DAY, 0);  
	       calendar.set(Calendar.MINUTE, 0);  
	       calendar.set(Calendar.SECOND,0);  
	       long min = calendar.getTime().getTime();;  
	       calendar.set(2015,11,31);  
	       calendar.set(Calendar.HOUR_OF_DAY,0);  
	       calendar.set(Calendar.MINUTE,0);  
	       calendar.set(Calendar.SECOND,0);  
	       calendar.getTime().getTime();  
	       long max = calendar.getTime().getTime();  
	       //得到大于等于min小于max的double值  
	       double randomDate = Math.random()*(max-min)+min;  
	       //将double值舍入为整数，转化成long类型  
	       calendar.setTimeInMillis(Math.round(randomDate));  
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	       
	       return sdf.format(calendar.getTime());
	   }  

	public String createHanzi() {
        String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        byte[] b1 = new byte[2];
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        b1[0] = (Integer.valueOf(hightPos)).byteValue();
        b1[1] = (Integer.valueOf(lowPos)).byteValue();

        byte[] b2 = new byte[2];
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        b2[0] = (Integer.valueOf(hightPos)).byteValue();
        b2[1] = (Integer.valueOf(lowPos)).byteValue();
        
        try {
            str = new String(b1, "GBK") + new String(b2, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str;
    }

	/**
	 * 
	 * @param maxNumber
	 * @param type hanzi, date
	 * @return
	 */
	public List<String> getListByType(int maxNumber, String type){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < maxNumber; i ++) {
			String tmpStr = null;
			if ("hanzi".equals(type)) {
				tmpStr = this.createHanzi();
			} else if ("date".equals(type)) {
				tmpStr = this.createDate();
			}
			list.add(tmpStr);
		}
		
		return list;
	}
	
	public String getValueFromList(List<String> list) {
		String rtn = "";
		int index=(int)(Math.random()*list.size());
		rtn = list.get(index);
		return rtn;
	}
	
	public boolean outputFile() throws IOException {
		boolean flag = true;

		List<String> hanziList1 = this.getListByType(200, "hanzi");
		List<String> hanziList2 = this.getListByType(20, "hanzi");
		List<String> hanziList3 = this.getListByType(60, "hanzi");
		List<String> hanziList4 = this.getListByType(40, "hanzi");
		

        File file = new File("test1000W.csv");
        if (!file.exists()) {  
            file.createNewFile();  
        }
        
        FileOutputStream fos = new FileOutputStream(file);  
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");  
        BufferedWriter out = new BufferedWriter(osw);
        
        long i = 0L;  
        out.write("姓名");  
        out.write(",");  
        out.write("部门"); 
        out.write(",");  
        out.write("产品"); 
        out.write(",");  
        out.write("类型"); 
        out.write(",");          
        out.write("销售日期"); 
        out.write(",");      
        out.write("汉字凑数2"); 
        out.write(",");   
        out.write("汉字凑数3"); 
        out.write(",");   
        out.write("汉字凑数4"); 
        out.write(",");   
        out.write("汉字凑数5"); 
        out.write(",");   
        out.write("汉字凑数6"); 
        out.write(",");   
        out.write("汉字凑数7"); 
        out.write(",");   
        out.write("销售额"); 
        out.write(",");  
        out.write("产品数量"); 
        out.write(",");
        out.write("凑数度量1"); 
        out.write(","); 
        out.write("凑数度量2"); 
        out.write(","); 
        out.write("凑数度量3"); 
        out.write(","); 
        out.write("凑数度量4"); 
        out.write(","); 
        out.write("凑数度量5"); 
        out.write(","); 
        out.write("凑数度量6"); 
        out.write(","); 
        out.write("盈亏"); 
        out.newLine();  
        while(i<10000000L){  
        	//System.out.println(i);
            i++;  
            out.write(this.getValueFromList(hanziList1));  
            out.write(",");  
            out.write(this.getValueFromList(hanziList2));  
            out.write(",");  
            out.write(this.getValueFromList(hanziList3));  
            out.write(",");
            out.write(this.getValueFromList(hanziList4));  
            out.write(",");
            out.write(this.createDate());  
            out.write(",");
            out.write(this.createHanzi());  
            out.write(",");
            out.write(this.createHanzi());  
            out.write(",");
            out.write(this.createHanzi());  
            out.write(",");
            out.write(this.createHanzi());  
            out.write(",");
            out.write(this.createHanzi());  
            out.write(",");
            out.write(this.createHanzi());  
            out.write(",");
            //---measure
            out.write(Integer.toString(this.createInt()));  
            out.write(",");  
            out.write(Integer.toString(this.createInt()));  
            out.write(",");  
            out.write(Integer.toString(this.createInt()));  
            out.write(","); 
            out.write(Integer.toString(this.createInt()));  
            out.write(","); 
            out.write(Integer.toString(this.createInt()));  
            out.write(","); 
            out.write(Integer.toString(this.createInt()));  
            out.write(","); 
            out.write(Integer.toString(this.createInt()));  
            out.write(","); 
            out.write(Integer.toString(this.createInt()));  
            out.write(","); 
            out.write(Integer.toString(this.createInt()));  
            out.newLine();  
            if(i%100000 ==0){  
                out.flush();  
            }             
        }         
        out.close();  
        System.out.println("生成完毕");
		return flag;
	}
	
	public boolean outputDB() {
		boolean flag = true;
		
		
		
		
		
		
		
		
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CreateRandomInt cri = new CreateRandomInt();
		//cri.outputFile();		
	}
}
