package com.tom.model.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNull() {
            addCriterion("staff_no is null");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNotNull() {
            addCriterion("staff_no is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNoEqualTo(Integer value) {
            addCriterion("staff_no =", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotEqualTo(Integer value) {
            addCriterion("staff_no <>", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThan(Integer value) {
            addCriterion("staff_no >", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_no >=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThan(Integer value) {
            addCriterion("staff_no <", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThanOrEqualTo(Integer value) {
            addCriterion("staff_no <=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoIn(List<Integer> values) {
            addCriterion("staff_no in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotIn(List<Integer> values) {
            addCriterion("staff_no not in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoBetween(Integer value1, Integer value2) {
            addCriterion("staff_no between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_no not between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDeptIsNull() {
            addCriterion("dept is null");
            return (Criteria) this;
        }

        public Criteria andDeptIsNotNull() {
            addCriterion("dept is not null");
            return (Criteria) this;
        }

        public Criteria andDeptEqualTo(String value) {
            addCriterion("dept =", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotEqualTo(String value) {
            addCriterion("dept <>", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThan(String value) {
            addCriterion("dept >", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThanOrEqualTo(String value) {
            addCriterion("dept >=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThan(String value) {
            addCriterion("dept <", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThanOrEqualTo(String value) {
            addCriterion("dept <=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLike(String value) {
            addCriterion("dept like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotLike(String value) {
            addCriterion("dept not like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptIn(List<String> values) {
            addCriterion("dept in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotIn(List<String> values) {
            addCriterion("dept not in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptBetween(String value1, String value2) {
            addCriterion("dept between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotBetween(String value1, String value2) {
            addCriterion("dept not between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andTime1IsNull() {
            addCriterion("time1 is null");
            return (Criteria) this;
        }

        public Criteria andTime1IsNotNull() {
            addCriterion("time1 is not null");
            return (Criteria) this;
        }

        public Criteria andTime1EqualTo(Date value) {
            addCriterion("time1 =", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1NotEqualTo(Date value) {
            addCriterion("time1 <>", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1GreaterThan(Date value) {
            addCriterion("time1 >", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("time1 >=", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1LessThan(Date value) {
            addCriterion("time1 <", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1LessThanOrEqualTo(Date value) {
            addCriterion("time1 <=", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1In(List<Date> values) {
            addCriterion("time1 in", values, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1NotIn(List<Date> values) {
            addCriterion("time1 not in", values, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1Between(Date value1, Date value2) {
            addCriterion("time1 between", value1, value2, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1NotBetween(Date value1, Date value2) {
            addCriterion("time1 not between", value1, value2, "time1");
            return (Criteria) this;
        }

        public Criteria andTime2IsNull() {
            addCriterion("time2 is null");
            return (Criteria) this;
        }

        public Criteria andTime2IsNotNull() {
            addCriterion("time2 is not null");
            return (Criteria) this;
        }

        public Criteria andTime2EqualTo(Date value) {
            addCriterion("time2 =", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2NotEqualTo(Date value) {
            addCriterion("time2 <>", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2GreaterThan(Date value) {
            addCriterion("time2 >", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("time2 >=", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2LessThan(Date value) {
            addCriterion("time2 <", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2LessThanOrEqualTo(Date value) {
            addCriterion("time2 <=", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2In(List<Date> values) {
            addCriterion("time2 in", values, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2NotIn(List<Date> values) {
            addCriterion("time2 not in", values, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2Between(Date value1, Date value2) {
            addCriterion("time2 between", value1, value2, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2NotBetween(Date value1, Date value2) {
            addCriterion("time2 not between", value1, value2, "time2");
            return (Criteria) this;
        }

        public Criteria andTime3IsNull() {
            addCriterion("time3 is null");
            return (Criteria) this;
        }

        public Criteria andTime3IsNotNull() {
            addCriterion("time3 is not null");
            return (Criteria) this;
        }

        public Criteria andTime3EqualTo(Date value) {
            addCriterion("time3 =", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3NotEqualTo(Date value) {
            addCriterion("time3 <>", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3GreaterThan(Date value) {
            addCriterion("time3 >", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3GreaterThanOrEqualTo(Date value) {
            addCriterion("time3 >=", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3LessThan(Date value) {
            addCriterion("time3 <", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3LessThanOrEqualTo(Date value) {
            addCriterion("time3 <=", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3In(List<Date> values) {
            addCriterion("time3 in", values, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3NotIn(List<Date> values) {
            addCriterion("time3 not in", values, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3Between(Date value1, Date value2) {
            addCriterion("time3 between", value1, value2, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3NotBetween(Date value1, Date value2) {
            addCriterion("time3 not between", value1, value2, "time3");
            return (Criteria) this;
        }

        public Criteria andTime4IsNull() {
            addCriterion("time4 is null");
            return (Criteria) this;
        }

        public Criteria andTime4IsNotNull() {
            addCriterion("time4 is not null");
            return (Criteria) this;
        }

        public Criteria andTime4EqualTo(Date value) {
            addCriterion("time4 =", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4NotEqualTo(Date value) {
            addCriterion("time4 <>", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4GreaterThan(Date value) {
            addCriterion("time4 >", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4GreaterThanOrEqualTo(Date value) {
            addCriterion("time4 >=", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4LessThan(Date value) {
            addCriterion("time4 <", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4LessThanOrEqualTo(Date value) {
            addCriterion("time4 <=", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4In(List<Date> values) {
            addCriterion("time4 in", values, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4NotIn(List<Date> values) {
            addCriterion("time4 not in", values, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4Between(Date value1, Date value2) {
            addCriterion("time4 between", value1, value2, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4NotBetween(Date value1, Date value2) {
            addCriterion("time4 not between", value1, value2, "time4");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}