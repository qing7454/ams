/***********************************************************************
 * Module:  项目表.java
 * Author:  simon
 * Purpose: Defines the Class 项目表
 ***********************************************************************/

import java.util.*;

/** @pdOid 6b7965a6-3c22-40c1-a499-e5eee82ef506 */
public class 项目表 {
   /** @pdOid 1cbe38c6-3b1e-4ac0-85d6-a3860b5a6b30 */
   public java.lang.String 项目编号;
   /** @pdOid 43227fe9-9fad-47f5-a610-65d7fd339ff9 */
   public java.lang.String 项目名称;
   /** @pdOid 5f093181-c9fa-41ad-9be8-5513aa7823dd */
   public java.lang.String 项目负责人;
   
   /** @pdRoleInfo migr=no name=资产信息表 assc=reference8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<资产信息表> 资产信息表;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<资产信息表> get资产信息表() {
      if (资产信息表 == null)
         资产信息表 = new java.util.HashSet<资产信息表>();
      return 资产信息表;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIterator资产信息表() {
      if (资产信息表 == null)
         资产信息表 = new java.util.HashSet<资产信息表>();
      return 资产信息表.iterator();
   }
   
   /** @pdGenerated default setter
     * @param new资产信息表 */
   public void set资产信息表(java.util.Collection<资产信息表> new资产信息表) {
      removeAll资产信息表();
      for (java.util.Iterator iter = new资产信息表.iterator(); iter.hasNext();)
         add资产信息表((资产信息表)iter.next());
   }
   
   /** @pdGenerated default add
     * @param new资产信息表 */
   public void add资产信息表(资产信息表 new资产信息表) {
      if (new资产信息表 == null)
         return;
      if (this.资产信息表 == null)
         this.资产信息表 = new java.util.HashSet<资产信息表>();
      if (!this.资产信息表.contains(new资产信息表))
      {
         this.资产信息表.add(new资产信息表);
         new资产信息表.set项目表(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param old资产信息表 */
   public void remove资产信息表(资产信息表 old资产信息表) {
      if (old资产信息表 == null)
         return;
      if (this.资产信息表 != null)
         if (this.资产信息表.contains(old资产信息表))
         {
            this.资产信息表.remove(old资产信息表);
            old资产信息表.set项目表((项目表)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAll资产信息表() {
      if (资产信息表 != null)
      {
         资产信息表 old资产信息表;
         for (java.util.Iterator iter = getIterator资产信息表(); iter.hasNext();)
         {
            old资产信息表 = (资产信息表)iter.next();
            iter.remove();
            old资产信息表.set项目表((项目表)null);
         }
      }
   }

}