package com.service;

import java.util.List;
import com.model.ding;
import com.model.huo;
import com.model.yonghu;
public interface IUserService {
	
	//����
	// ��ӻ�����Ϣ����Ҫ����huo����6������
	public boolean add(huo huo);
	
	// ɾ��������Ϣ����Ҫwid
	public boolean delete(Integer wid);

	// �޸Ļ�����Ϣ����Ҫ�޸�huo6������
	public boolean update(huo huo);

	//��ѯ�����û���Ϣ����Ҫyid
	public List<yonghu> yonghuqueryAll(String yid);
	
	//��ѯ���еĻ���
	public List<huo> huoqueryAll();
	
	//��ѯ���˷����Ļ����Ҫyid
	public List<huo> gehuoqueryAll(String wyid);
	
	//��ѯ���˶�������Ҫyid
	public List<ding> dingqueryAll(String dbuy);

	//����û���Ϣ����Ҫyonghu4������
	public boolean yadd(yonghu yong);
	
	//�ж�ע���Ƿ�����������Ҫyonghu�������ԣ�yid��yname
	public boolean cun(yonghu yong);
	
	//����
	//��ù����������֣���Ҫ�����wid
	public String buyname (Integer wid);
	
	//��ӹ������Ķ�������Ҫding��������
	public boolean buyadd(ding ding);
	
	

}
