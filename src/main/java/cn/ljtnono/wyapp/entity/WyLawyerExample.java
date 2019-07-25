package cn.ljtnono.wyapp.entity;

import java.util.ArrayList;
import java.util.List;

public class WyLawyerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public WyLawyerExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdIsNull() {
            addCriterion("laywer_id is null");
            return (Criteria) this;
        }

        public Criteria andLaywerIdIsNotNull() {
            addCriterion("laywer_id is not null");
            return (Criteria) this;
        }

        public Criteria andLaywerIdEqualTo(String value) {
            addCriterion("laywer_id =", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdNotEqualTo(String value) {
            addCriterion("laywer_id <>", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdGreaterThan(String value) {
            addCriterion("laywer_id >", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdGreaterThanOrEqualTo(String value) {
            addCriterion("laywer_id >=", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdLessThan(String value) {
            addCriterion("laywer_id <", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdLessThanOrEqualTo(String value) {
            addCriterion("laywer_id <=", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdLike(String value) {
            addCriterion("laywer_id like", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdNotLike(String value) {
            addCriterion("laywer_id not like", value, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdIn(List<String> values) {
            addCriterion("laywer_id in", values, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdNotIn(List<String> values) {
            addCriterion("laywer_id not in", values, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdBetween(String value1, String value2) {
            addCriterion("laywer_id between", value1, value2, "laywerId");
            return (Criteria) this;
        }

        public Criteria andLaywerIdNotBetween(String value1, String value2) {
            addCriterion("laywer_id not between", value1, value2, "laywerId");
            return (Criteria) this;
        }

        public Criteria andInstitutionIsNull() {
            addCriterion("institution is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionIsNotNull() {
            addCriterion("institution is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionEqualTo(String value) {
            addCriterion("institution =", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionNotEqualTo(String value) {
            addCriterion("institution <>", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionGreaterThan(String value) {
            addCriterion("institution >", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionGreaterThanOrEqualTo(String value) {
            addCriterion("institution >=", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionLessThan(String value) {
            addCriterion("institution <", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionLessThanOrEqualTo(String value) {
            addCriterion("institution <=", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionLike(String value) {
            addCriterion("institution like", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionNotLike(String value) {
            addCriterion("institution not like", value, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionIn(List<String> values) {
            addCriterion("institution in", values, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionNotIn(List<String> values) {
            addCriterion("institution not in", values, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionBetween(String value1, String value2) {
            addCriterion("institution between", value1, value2, "institution");
            return (Criteria) this;
        }

        public Criteria andInstitutionNotBetween(String value1, String value2) {
            addCriterion("institution not between", value1, value2, "institution");
            return (Criteria) this;
        }

        public Criteria andServerAreaIsNull() {
            addCriterion("server_area is null");
            return (Criteria) this;
        }

        public Criteria andServerAreaIsNotNull() {
            addCriterion("server_area is not null");
            return (Criteria) this;
        }

        public Criteria andServerAreaEqualTo(Integer value) {
            addCriterion("server_area =", value, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaNotEqualTo(Integer value) {
            addCriterion("server_area <>", value, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaGreaterThan(Integer value) {
            addCriterion("server_area >", value, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_area >=", value, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaLessThan(Integer value) {
            addCriterion("server_area <", value, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaLessThanOrEqualTo(Integer value) {
            addCriterion("server_area <=", value, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaIn(List<Integer> values) {
            addCriterion("server_area in", values, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaNotIn(List<Integer> values) {
            addCriterion("server_area not in", values, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaBetween(Integer value1, Integer value2) {
            addCriterion("server_area between", value1, value2, "serverArea");
            return (Criteria) this;
        }

        public Criteria andServerAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("server_area not between", value1, value2, "serverArea");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("`domain` is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("`domain` is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(Integer value) {
            addCriterion("`domain` =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(Integer value) {
            addCriterion("`domain` <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(Integer value) {
            addCriterion("`domain` >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(Integer value) {
            addCriterion("`domain` >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(Integer value) {
            addCriterion("`domain` <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(Integer value) {
            addCriterion("`domain` <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<Integer> values) {
            addCriterion("`domain` in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<Integer> values) {
            addCriterion("`domain` not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(Integer value1, Integer value2) {
            addCriterion("`domain` between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(Integer value1, Integer value2) {
            addCriterion("`domain` not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andServiceAddrIsNull() {
            addCriterion("service_addr is null");
            return (Criteria) this;
        }

        public Criteria andServiceAddrIsNotNull() {
            addCriterion("service_addr is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAddrEqualTo(String value) {
            addCriterion("service_addr =", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrNotEqualTo(String value) {
            addCriterion("service_addr <>", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrGreaterThan(String value) {
            addCriterion("service_addr >", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrGreaterThanOrEqualTo(String value) {
            addCriterion("service_addr >=", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrLessThan(String value) {
            addCriterion("service_addr <", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrLessThanOrEqualTo(String value) {
            addCriterion("service_addr <=", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrLike(String value) {
            addCriterion("service_addr like", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrNotLike(String value) {
            addCriterion("service_addr not like", value, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrIn(List<String> values) {
            addCriterion("service_addr in", values, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrNotIn(List<String> values) {
            addCriterion("service_addr not in", values, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrBetween(String value1, String value2) {
            addCriterion("service_addr between", value1, value2, "serviceAddr");
            return (Criteria) this;
        }

        public Criteria andServiceAddrNotBetween(String value1, String value2) {
            addCriterion("service_addr not between", value1, value2, "serviceAddr");
            return (Criteria) this;
        }
    }

    /**
     */
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