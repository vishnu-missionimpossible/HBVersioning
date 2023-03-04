package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class VersionModify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		MobileCustomer customer = null;
		boolean flag = false;
		
		session = HibernateUtil.getSession();
		
		try {
			
			transaction = session.beginTransaction();
			customer = session.get(MobileCustomer.class, 1);
			  
				if (customer != null) {
					  System.out.println(customer);
					customer.setCallerTune("kantara");
					customer.setCname("Ravi");
					flag = true;
				}else {
					System.out.println("Record not available...");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object is modified...");
				System.out.println("Object is modified for :: "+customer.getVersionCount()+" times");
			}else {
				transaction.rollback();
				System.out.println("Object modification failed...");
			}
			
			HibernateUtil.closeSession(session);
		}
		

	}

}
