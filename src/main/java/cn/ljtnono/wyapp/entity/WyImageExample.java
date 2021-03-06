package cn.ljtnono.wyapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WyImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public WyImageExample() {
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

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeIsNull() {
            addCriterion("image_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeIsNotNull() {
            addCriterion("image_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeEqualTo(Date value) {
            addCriterion("image_upload_time =", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeNotEqualTo(Date value) {
            addCriterion("image_upload_time <>", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeGreaterThan(Date value) {
            addCriterion("image_upload_time >", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("image_upload_time >=", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeLessThan(Date value) {
            addCriterion("image_upload_time <", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("image_upload_time <=", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeIn(List<Date> values) {
            addCriterion("image_upload_time in", values, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeNotIn(List<Date> values) {
            addCriterion("image_upload_time not in", values, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeBetween(Date value1, Date value2) {
            addCriterion("image_upload_time between", value1, value2, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("image_upload_time not between", value1, value2, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeIsNull() {
            addCriterion("image_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeIsNotNull() {
            addCriterion("image_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeEqualTo(Date value) {
            addCriterion("image_modify_time =", value, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeNotEqualTo(Date value) {
            addCriterion("image_modify_time <>", value, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeGreaterThan(Date value) {
            addCriterion("image_modify_time >", value, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("image_modify_time >=", value, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeLessThan(Date value) {
            addCriterion("image_modify_time <", value, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("image_modify_time <=", value, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeIn(List<Date> values) {
            addCriterion("image_modify_time in", values, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeNotIn(List<Date> values) {
            addCriterion("image_modify_time not in", values, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeBetween(Date value1, Date value2) {
            addCriterion("image_modify_time between", value1, value2, "imageModifyTime");
            return (Criteria) this;
        }

        public Criteria andImageModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("image_modify_time not between", value1, value2, "imageModifyTime");
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