package com.mapper;
import java.util.List;

import com.model.ding;
import com.model.huo;
import com.model.yonghu;
public  interface UserMapper{
	//�û�
		public int ysave(yonghu yong);
	//	
		public int getcun(yonghu yong);

	//���˻���
		public List<yonghu> getgeren(String yid);
		
		// ��ѯȫ���û���Ϣ
		public List<huo> getgehuo(String wyid);
		
		// ���һ���û���Ϣ	
		public int save(huo huo);
		
		// ɾ��һ���û���Ϣ
		public int delete(Integer wid);
		
		// �޸�һ���û���Ϣ
		public int update(huo huo);
		

	
	//����
		public List<huo> gethuo();
		
		public int buysave(ding ding);
		
		public String buyname(Integer wid);
	//����
		
		public List<ding> getding(String dbuy);
	

	
}
