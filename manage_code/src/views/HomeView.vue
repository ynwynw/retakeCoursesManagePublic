<template>
  <div class="home_view">
    <div class="projectTitle">欢迎使用 {{ projectName }}</div>
    <div class="count_list">
      <el-collapse-transition v-if="btnAuth('xuesheng', '首页总数')">
        <el-card
          v-show="countTypeList.closexueshengCountType"
          class="card_view count-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">学生</div>
              <div class="card_head_right">
                <el-icon
                  @click="countTypeClick('hiddenxueshengCountType')"
                  class="showIcons"
                  :class="
                    countTypeList.hiddenxueshengCountType ? 'showIcons1' : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="countTypeClick('closexueshengCountType')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="count_item"
              v-show="countTypeList.hiddenxueshengCountType"
            >
              <div class="count_title">学生总数</div>
              <div class="count_num">{{ xueshengCount }}</div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('banzhuren', '首页总数')">
        <el-card
          v-show="countTypeList.closebanzhurenCountType"
          class="card_view count-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">班主任</div>
              <div class="card_head_right">
                <el-icon
                  @click="countTypeClick('hiddenbanzhurenCountType')"
                  class="showIcons"
                  :class="
                    countTypeList.hiddenbanzhurenCountType ? 'showIcons1' : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="countTypeClick('closebanzhurenCountType')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="count_item"
              v-show="countTypeList.hiddenbanzhurenCountType"
            >
              <div class="count_title">班主任总数</div>
              <div class="count_num">{{ banzhurenCount }}</div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('kechengchengji', '首页总数')">
        <el-card
          v-show="countTypeList.closekechengchengjiCountType"
          class="card_view count-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">课程成绩</div>
              <div class="card_head_right">
                <el-icon
                  @click="countTypeClick('hiddenkechengchengjiCountType')"
                  class="showIcons"
                  :class="
                    countTypeList.hiddenkechengchengjiCountType
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="countTypeClick('closekechengchengjiCountType')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="count_item"
              v-show="countTypeList.hiddenkechengchengjiCountType"
            >
              <div class="count_title">课程成绩总数</div>
              <div class="count_num">{{ kechengchengjiCount }}</div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('shenqingfuhe', '首页总数')">
        <el-card
          v-show="countTypeList.closeshenqingfuheCountType"
          class="card_view count-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">申请复核</div>
              <div class="card_head_right">
                <el-icon
                  @click="countTypeClick('hiddenshenqingfuheCountType')"
                  class="showIcons"
                  :class="
                    countTypeList.hiddenshenqingfuheCountType
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="countTypeClick('closeshenqingfuheCountType')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="count_item"
              v-show="countTypeList.hiddenshenqingfuheCountType"
            >
              <div class="count_title">申请复核总数</div>
              <div class="count_num">{{ shenqingfuheCount }}</div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('zhongxiukecheng', '首页总数')">
        <el-card
          v-show="countTypeList.closezhongxiukechengCountType"
          class="card_view count-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">重修课程</div>
              <div class="card_head_right">
                <el-icon
                  @click="countTypeClick('hiddenzhongxiukechengCountType')"
                  class="showIcons"
                  :class="
                    countTypeList.hiddenzhongxiukechengCountType
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="countTypeClick('closezhongxiukechengCountType')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="count_item"
              v-show="countTypeList.hiddenzhongxiukechengCountType"
            >
              <div class="count_title">重修课程总数</div>
              <div class="count_num">{{ zhongxiukechengCount }}</div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
    </div>
    <div class="card_list">
      <el-collapse-transition v-if="btnAuth('kechengchengji', '首页统计')">
        <el-card
          v-show="cardTypeList.closekechengchengjiChartType1"
          class="card_view chart-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">课程成绩</div>
              <div class="card_head_right">
                <el-icon
                  @click="cardTypeClick('hiddenkechengchengjiChartType1')"
                  class="showIcons"
                  :class="
                    cardTypeList.hiddenkechengchengjiChartType1
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="cardTypeClick('closekechengchengjiChartType1')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="card_item"
              v-show="cardTypeList.hiddenkechengchengjiChartType1"
            >
              <div
                id="kechengchengjikechengchengjiEchart1"
                class="Echart"
                style="width: 100%; height: 400px"
              ></div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('kechengchengji', '首页统计')">
        <el-card
          v-show="cardTypeList.closekechengchengjiChartType2"
          class="card_view chart-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">课程成绩</div>
              <div class="card_head_right">
                <el-icon
                  @click="cardTypeClick('hiddenkechengchengjiChartType2')"
                  class="showIcons"
                  :class="
                    cardTypeList.hiddenkechengchengjiChartType2
                      ? 'showIcons2'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="cardTypeClick('closekechengchengjiChartType2')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="card_item"
              v-show="cardTypeList.hiddenkechengchengjiChartType2"
            >
              <div
                id="kechengchengjikechengxuefenEchart2"
                class="Echart"
                style="width: 100%; height: 400px"
              ></div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('shenqingfuhe', '首页统计')">
        <el-card
          v-show="cardTypeList.closeshenqingfuheChartType1"
          class="card_view chart-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">申请复核</div>
              <div class="card_head_right">
                <el-icon
                  @click="cardTypeClick('hiddenshenqingfuheChartType1')"
                  class="showIcons"
                  :class="
                    cardTypeList.hiddenshenqingfuheChartType1
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="cardTypeClick('closeshenqingfuheChartType1')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="card_item"
              v-show="cardTypeList.hiddenshenqingfuheChartType1"
            >
              <div
                id="shenqingfuhejiaonafeiyongEchart1"
                class="Echart"
                style="width: 100%; height: 400px"
              ></div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('zhongxiukecheng', '首页统计')">
        <el-card
          v-show="cardTypeList.closezhongxiukechengChartType1"
          class="card_view chart-item"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">重修课程</div>
              <div class="card_head_right">
                <el-icon
                  @click="cardTypeClick('hiddenzhongxiukechengChartType1')"
                  class="showIcons"
                  :class="
                    cardTypeList.hiddenzhongxiukechengChartType1
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="cardTypeClick('closezhongxiukechengChartType1')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="card_item"
              v-show="cardTypeList.hiddenzhongxiukechengChartType1"
            >
              <div
                id="zhongxiukechengkechengmingchengEchart1"
                class="Echart"
                style="width: 100%; height: 400px"
              ></div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
    </div>
  </div>
</template>

<script setup>
import { inject, nextTick, ref, getCurrentInstance } from 'vue'
const context = getCurrentInstance()?.appContext.config.globalProperties
const projectName = context.$project.projectName
const countTypeList = ref({})
const getCountList = () => {
  countTypeList.value.closexueshengCountType = true
  countTypeList.value.hiddenxueshengCountType = true
  if (btnAuth('xuesheng', '首页总数')) {
    getxueshengCount()
  }
  countTypeList.value.closebanzhurenCountType = true
  countTypeList.value.hiddenbanzhurenCountType = true
  if (btnAuth('banzhuren', '首页总数')) {
    getbanzhurenCount()
  }
  countTypeList.value.closekechengchengjiCountType = true
  countTypeList.value.hiddenkechengchengjiCountType = true
  if (btnAuth('kechengchengji', '首页总数')) {
    getkechengchengjiCount()
  }
  countTypeList.value.closeshenqingfuheCountType = true
  countTypeList.value.hiddenshenqingfuheCountType = true
  if (btnAuth('shenqingfuhe', '首页总数')) {
    getshenqingfuheCount()
  }
  countTypeList.value.closezhongxiukechengCountType = true
  countTypeList.value.hiddenzhongxiukechengCountType = true
  if (btnAuth('zhongxiukecheng', '首页总数')) {
    getzhongxiukechengCount()
  }
}
const xueshengCount = ref(0)
const getxueshengCount = () => {
  context
    ?.$http({
      url: 'xuesheng/count',
      method: 'get',
    })
    .then((res) => {
      xueshengCount.value = res.data.data
    })
}
const banzhurenCount = ref(0)
const getbanzhurenCount = () => {
  context
    ?.$http({
      url: 'banzhuren/count',
      method: 'get',
    })
    .then((res) => {
      banzhurenCount.value = res.data.data
    })
}
const kechengchengjiCount = ref(0)
const getkechengchengjiCount = () => {
  context
    ?.$http({
      url: 'kechengchengji/count',
      method: 'get',
    })
    .then((res) => {
      kechengchengjiCount.value = res.data.data
    })
}
const shenqingfuheCount = ref(0)
const getshenqingfuheCount = () => {
  context
    ?.$http({
      url: 'shenqingfuhe/count',
      method: 'get',
    })
    .then((res) => {
      shenqingfuheCount.value = res.data.data
    })
}
const zhongxiukechengCount = ref(0)
const getzhongxiukechengCount = () => {
  context
    ?.$http({
      url: 'zhongxiukecheng/count',
      method: 'get',
    })
    .then((res) => {
      zhongxiukechengCount.value = res.data.data
    })
}
const countTypeClick = (e) => {
  countTypeList.value[e] = !countTypeList.value[e]
}
//权限验证
const btnAuth = (e, a) => {
  return context?.$toolUtil.isAuth(e, a)
}
let echarts = inject('echarts')
const cardTypeClick = (e) => {
  cardTypeList.value[e] = !cardTypeList.value[e]
  setTimeout(() => {
    getCardList()
  }, 1000)
}
const cardTypeList = ref({
  closekechengchengjiChartType1: true,
  hiddenkechengchengjiChartType1: true,
  closekechengchengjiChartType2: true,
  hiddenkechengchengjiChartType2: true,
  closeshenqingfuheChartType1: true,
  hiddenshenqingfuheChartType1: true,
  closezhongxiukechengChartType1: true,
  hiddenzhongxiukechengChartType1: true,
})
const getCardList = () => {
  if (btnAuth('kechengchengji', '首页统计')) {
    getkechengchengjiChart1()
  }
  if (btnAuth('kechengchengji', '首页统计')) {
    getkechengchengjiChart2()
  }
  if (btnAuth('shenqingfuhe', '首页统计')) {
    getshenqingfuheChart1()
  }
  if (btnAuth('zhongxiukecheng', '首页统计')) {
    getzhongxiukechengChart1()
  }
}
import '@/assets/js/echarts-theme'
const getkechengchengjiChart1 = () => {
  nextTick(() => {
    var kechengchengjiEchart1 = echarts.init(
      document.getElementById('kechengchengjikechengchengjiEchart1'),
      'theme'
    )
    context
      ?.$http({
        url: 'kechengchengji/sectionStat/kechengchengji/kechengmingcheng',
        method: 'get',
      })
      .then((obj) => {
        let res = obj.data.data
        let xAxis = []
        let yAxis1 = []
        let yAxis2 = []
        let yAxis3 = []
        let dataList = []
        for (let i = 0; i < res.length; i++) {
          xAxis.push(res[i].kechengmingcheng)
          yAxis1.push(parseFloat(res[i]['不及格']))
          yAxis2.push(parseFloat(res[i]['良']))
          yAxis3.push(parseFloat(res[i]['优']))
          dataList.push({
            name: res[i].kechengchengji,
          })
        }
        var option = {}
        let legend_data = ['不及格', '良', '优']
        let series = [
          {
            name: '不及格',
            data: yAxis1,
            type: 'bar',
          },
          {
            name: '良',
            data: yAxis2,
            type: 'bar',
          },
          {
            name: '优',
            data: yAxis3,
            type: 'bar',
          },
        ]
        option = {
          title: {
            text: '成绩统计',
            left: 'center',
          },
          grid: {
            containLabel: true,
          },
          legend: {
            data: legend_data,
            left: 'center',
            bottom: 4,
          },
          tooltip: {
            trigger: 'axis',
          },
          xAxis: {
            type: 'category',
            data: xAxis,
          },
          yAxis: {
            type: 'value',
          },
          series: series,
        }

        kechengchengjiEchart1.clear()
        // 使用刚指定的配置项和数据显示图表。
        kechengchengjiEchart1.setOption(option)
        //根据窗口的大小变动图表
        kechengchengjiEchart1.resize()
      })
  })
}
const getkechengchengjiChart2 = () => {
  nextTick(() => {
    var kechengxuefenEchart2 = echarts.init(
      document.getElementById('kechengchengjikechengxuefenEchart2'),
      'theme'
    )
    context
      ?.$http({
        url: `kechengchengji/value/kechengmingcheng/kechengxuefen`,
        method: 'get',
      })
      .then((obj) => {
        let res = obj.data.data
        let xAxis = []
        let yAxis = []
        let dataList = []
        for (let i = 0; i < res.length; i++) {
          xAxis.push(res[i].kechengmingcheng)
          yAxis.push(parseFloat(res[i].total))
          dataList.push({
            value: parseFloat(res[i].total),
            name: res[i].kechengmingcheng,
          })
        }
        var option = {}
        option = {
          title: {
            text: '学分统计',
            left: 'center',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c}',
          },
          xAxis: {
            data: xAxis,
            type: 'category',
          },
          yAxis: {
            type: 'value',
          },
          series: {
            data: yAxis,
            type: 'line',
          },
        }
        kechengxuefenEchart2.clear()
        // 使用刚指定的配置项和数据显示图表。
        kechengxuefenEchart2.setOption(option)
        //根据窗口的大小变动图表
        kechengxuefenEchart2.resize()
      })
  })
}
const getshenqingfuheChart1 = () => {
  nextTick(() => {
    var jiaonafeiyongEchart1 = echarts.init(
      document.getElementById('shenqingfuhejiaonafeiyongEchart1'),
      'theme'
    )
    context
      ?.$http({
        url: `shenqingfuhe/value/kechengmingcheng/jiaonafeiyong`,
        method: 'get',
      })
      .then((obj) => {
        let res = obj.data.data
        let xAxis = []
        let yAxis = []
        let dataList = []
        for (let i = 0; i < res.length; i++) {
          xAxis.push(res[i].kechengmingcheng)
          yAxis.push(parseFloat(res[i].total))
          dataList.push({
            value: parseFloat(res[i].total),
            name: res[i].kechengmingcheng,
          })
        }
        var option = {}
        option = {
          title: {
            text: '重修费用统计',
            left: 'center',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c}',
          },
          xAxis: {
            data: xAxis,
            type: 'category',
            axisLabel: {
              interval: 0,
              rotate: 30,
            },
          },
          yAxis: {
            type: 'value',
            minInterval: 1,
          },
          series: {
            data: yAxis,
            type: 'bar',
          },
        }

        jiaonafeiyongEchart1.clear()
        // 使用刚指定的配置项和数据显示图表。
        jiaonafeiyongEchart1.setOption(option)
        //根据窗口的大小变动图表
        jiaonafeiyongEchart1.resize()
      })
  })
}
const getzhongxiukechengChart1 = () => {
  nextTick(() => {
    var kechengmingchengEchart1 = echarts.init(
      document.getElementById('zhongxiukechengkechengmingchengEchart1'),
      'theme'
    )
    context
      ?.$http({
        url: 'zhongxiukecheng/group/kechengmingcheng',
        method: 'get',
      })
      .then((obj) => {
        let res = obj.data.data
        let xAxis = []
        let yAxis = []
        let dataList = []
        for (let i = 0; i < res.length; i++) {
          xAxis.push(res[i].kechengmingcheng)
          yAxis.push(parseFloat(res[i].total))
          dataList.push({
            value: parseFloat(res[i].total),
            name: res[i].kechengmingcheng,
          })
        }
        var option = {}
        option = {
          title: {
            text: '课程重修占比',
            left: 'center',
          },
          legend: {
            orient: 'vertical',
            left: 'left',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c} ({d}%)',
          },
          series: [
            {
              type: 'pie',
              radius: '55%',
              center: ['50%', '60%'],
              data: dataList,
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)',
                },
              },
            },
          ],
        }
        kechengmingchengEchart1.clear()
        // 使用刚指定的配置项和数据显示图表。
        kechengmingchengEchart1.setOption(option)
        //根据窗口的大小变动图表
        kechengmingchengEchart1.resize()
      })
  })
}

const init = () => {
  getCountList()
  getCardList()
}
init()
</script>
<style lang="scss">
// 首页盒子
.home_view {
  background-image: url('http://localhost:8080/retakeCoursesManage/file/4b085da9e49a4724bb79dd4dc0bb09f9.webp');
}
.home_view .projectTitle {
}

.showIcons {
  transition: transform 0.3s;
  margin-right: 10px;
}

.showIcons1 {
  transform: rotate(-180deg);
}

// 总数盒子
.count_list {
  // 总数card
  .card_view {
    // card头部
    .el-card__header {
      // 头部盒子
      .index_card_head {
        // 标题
        .card_head_title {
        }
        // 按钮盒子
        .card_head_right {
          // 按钮
          .el-icon {
          }
        }
      }
    }
    // body
    .el-card__body {
      // body盒子
      .count_item {
        // 总数标题
        .count_title {
        }
        // 总数数字
        .count_num {
        }
      }
    }
  }
}

// 统计图盒子
.card_list {
  // 统计图card
  .card_view {
    // 头部
    .el-card__header {
      // 头部盒子
      .index_card_head {
        // 标题
        .card_head_title {
        }
        // 按钮盒子
        .card_head_right {
          // 按钮
          .el-icon {
          }
        }
      }
    }
    // body
    .el-card__body {
      // body盒子
      .card_item {
      }
    }
  }
}
</style>
<style>
/*总盒子*/
.home_view {
  padding: 20px;
  margin: 20px;
  height: auto;
  min-height: 100vh;
  background: url(http://localhost:8080/retakeCoursesManage/file/405bb37018d4443d83da8cfa8e77e30e.png)
    no-repeat center top / cover !important;
  width: calc(100% - 40px);
  border-radius: 0px;
  border-top: 2px solid #339933;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
}
.home_view .projectTitle {
  width: 100%;
  font-size: 28px;
  font-weight: bold;
  padding: 40px 0px 20px;
  height: auto;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0px 0px 20px;
  color: rgb(55, 55, 55);
}

/*总数*/
/*总盒子*/
.home_view .count_list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  padding: 0px 0px 20px;
  width: 100%;
  align-items: flex-start;
}
/*卡片盒子*/
.home_view .count_list .card_view {
  width: 23%;
  height: auto;
  margin: 0px 1% 20px;
  box-sizing: border-box;
  border: 1px solid #33993330;
  border-radius: 0px;
  background: #fff;
  box-shadow: inset 0px 0px 56px 0px #33993330;
  flex: 1;
}

.home_view .count_list .card_view:nth-child(1) {
}
.home_view .count_list .card_view:nth-child(2) {
}
.home_view .count_list .card_view:nth-child(3) {
}
.home_view .count_list .card_view:nth-child(4) {
}
.home_view .count_list .card_view:nth-child(2n + 5) {
}
.home_view .count_list .card_view:nth-child(2n + 6) {
}
.home_view .count_list .card_view:nth-child(1):hover {
}
.home_view .count_list .card_view:nth-child(2):hover {
}
.home_view .count_list .card_view:nth-child(3):hover {
}
.home_view .count_list .card_view:nth-child(4):hover {
}
.home_view .count_list .card_view:nth-child(2n + 5):hover {
}
.home_view .count_list .card_view:nth-child(2n + 6):hover {
}

/*head 总盒子*/
.home_view .count_list .card_view .el-card__header {
  width: 100%;
  border: 0px solid rgb(238, 238, 238);
  display: none;
}
/*item*/
.home_view .count_list .card_view .el-card__header .index_card_head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 10px;
}
/*标题*/
.home_view
  .count_list
  .card_view
  .el-card__header
  .index_card_head
  .card_head_title {
  font-size: 14px;
  color: rgb(51, 51, 51);
}
/*按钮盒子*/
.home_view
  .count_list
  .card_view
  .el-card__header
  .index_card_head
  .card_head_right {
  display: flex;
  align-items: center;
}
/*按钮*/
.home_view
  .count_list
  .card_view
  .el-card__header
  .index_card_head
  .card_head_right
  .showIcons {
  color: rgb(102, 102, 102);
  font-size: 20px;
  cursor: pointer;
}
/*body 总盒子*/
.home_view .count_list .card_view .el-card__body {
  padding: 0px;
  background: none;
}
/*item*/
.home_view .count_list .card_view .el-card__body .count_item {
  padding: 10px;
  text-align: left;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: row;
}
/*标题*/
.home_view .count_list .card_view .el-card__body .count_item .count_title {
  font-size: 18px;
  color: rgb(105, 105, 105);
  line-height: 2;
  display: inline-block;
  margin: 0px 10px 0px 0px;
  font-weight: 500;
}
/*数字*/
.home_view .count_list .card_view .el-card__body .count_item .count_num {
  font-size: 26px;
  color: rgb(55, 55, 55);
  line-height: 2;
  display: inline-block;
  font-weight: 500;
}

/*图表*/
/*总盒子*/
.home_view .card_list {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  padding: 0px 0px 20px;
  align-items: flex-start;
  order: 11;
}
/*卡片 总盒子*/
.home_view .card_list .card_view {
  width: 48%;
  height: auto;
  margin: 0px 1% 30px;
  box-sizing: border-box;
  border: 1px solid #ddd;
  border-radius: 0px;
  padding: 20px 0px 0px;
  box-shadow: 0 0px 0px 0 rgba(0, 0, 0, 0.1);
}
/*head 总盒子*/
.home_view .card_list .card_view .el-card__header {
  width: 100%;
  border: 0px solid rgb(238, 238, 238);
  background: rgb(255, 255, 255);
  display: none;
}
/*item*/
.home_view .card_list .card_view .el-card__header .index_card_head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 10px;
}
/*标题*/
.home_view
  .card_list
  .card_view
  .el-card__header
  .index_card_head
  .card_head_title {
}
/*按钮盒子*/
.home_view
  .card_list
  .card_view
  .el-card__header
  .index_card_head
  .card_head_right {
  display: none;
}
/*按钮*/
.home_view
  .card_list
  .card_view
  .el-card__header
  .index_card_head
  .card_head_right
  .showIcons {
  color: rgb(238, 238, 238);
  font-size: 20px;
  cursor: pointer;
}

/*body 总盒子*/
.home_view .card_list .card_view .el-card__body {
  padding: 0px;
  background: rgb(255, 255, 255);
}
.home_view .card_list .card_view .el-card__body .card_item {
  padding: 10px;
  text-align: center;
}

.home-calendar {
  border: 1px solid rgb(218, 218, 218);
  box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 0px;
  margin: 0px auto 30px;
  border-radius: 0px;
  color: rgb(102, 102, 102);
  background: #fff;
  width: calc(100% - 30px);
  font-size: inherit;
  height: auto;
  padding: 0 0 10px;
  order: 2;
}
.home-calendar .header {
  padding: 17px 40px;
  border-color: rgba(126, 96, 16, 0.1);
  flex-wrap: wrap;
  background: rgba(23, 139, 23, 0.6);
  border-width: 0px 0px 1px;
  display: flex;
  width: 100%;
  border-style: solid;
  justify-content: space-between;
  height: auto;
}
.home-calendar .header .btn {
  cursor: pointer;
  border: 0px solid rgb(153, 153, 153);
  padding: 0px 0px 0px 12px;
  align-items: center;
  color: #fff;
  border-radius: 4px;
  display: flex;
  width: auto;
  font-size: 16px;
  justify-content: center;
}
.home-calendar .header .title {
  padding: 0px 10px;
  font-size: 24px;
  align-items: center;
  justify-content: center;
  display: flex;
  color: #fff;
}
.home-calendar table {
  width: 100%;
  padding: 0px 0px 20px;
  height: auto;
}
.home-calendar tbody,
thead {
  width: 100%;
}
.home-calendar tr {
  width: 100%;
  align-items: center;
  justify-content: center;
  display: flex;
}
.home-calendar th {
  align-items: center;
  flex: 1;
  display: flex;
  line-height: 50px;
  justify-content: center;
}
.home-calendar td {
  cursor: pointer;
  padding: 6px 12px 6px;
  flex: 1;
  display: flex;
  justify-content: center;
  text-align: center;
}
.home-calendar td.today .text {
  width: 80%;
  height: 80%;
  padding: 5px 0;
  background: rgba(23, 139, 23, 0.3);
  color: #fff;
}
.home-calendar td.festival .text {
  width: 80%;
  height: 80%;
  padding: 5px 0;
  background: rgba(23, 139, 23, 0.05);
}
</style>
