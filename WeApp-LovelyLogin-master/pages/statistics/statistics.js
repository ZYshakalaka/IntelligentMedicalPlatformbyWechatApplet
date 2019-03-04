var wxCharts = require('../../utils/wxcharts.js');
var app = getApp();
var pieChart = null;
var all = getApp().globalData;
Page({
  /**
   * 页面的初始数据
   */
  data: {
    array: ['体温', '心率', '血压'],
    index: 0,
    h:'',
    l:'',
    jsonr_h:[],
    jsonr_l:[],
    jsonp_h:[],
    jsonp_l:[],
    time:'',
    jsont_h: '',
  },
  bindPickerChange: function (e) {
    var windowWidth = 320;
    var that = this;
    try {
      var res = wx.getSystemInfoSync();
      windowWidth = res.windowWidth;
    } catch (e) {
      console.error('getSystemInfoSync failed!');
    }
    console.log('picker发送选择改变，携带值为', e.detail.value)
    if(e.detail.value == 0){      //0
      this.setData({
        h: '1.体温过高人次/体温正常人次(正常36~37°)：'+all.th,
        l: '2.体温过低人次/体温正常人次：'+all.tl,
      })
      var a = JSON.parse(all.jsont_hS).length;
      var arrays = new Array();
      for (var i = 0; i < a; i++) { 
        arrays[i] = {
          name: JSON.parse(all.jsont_hS)[i].name,
          data: parseInt(JSON.parse(all.jsont_hS)[i].data),
        }
      }
      pieChart = new wxCharts({
        animation: true,
        canvasId: 'pieCanvas',
        type: 'pie',
        series: arrays,
        width: windowWidth,
        height: 300,
        dataLabel: true,
      });
      var b = JSON.parse(all.jsont_lS).length;
      var arrays2 = new Array();
      for (var i = 0; i < b; i++) {
        arrays2[i] = {
          data: parseInt(JSON.parse(all.jsont_lS)[i].data),
          name: JSON.parse(all.jsont_lS)[i].name,
        }
      }
      pieChart2 = new wxCharts({
        animation: true,
        canvasId: 'pieCanvas2',
        type: 'pie',
        series: arrays2,
        width: windowWidth,
        height: 300,
        dataLabel: true,
      });
    } else if (e.detail.value == 1){   //1
      this.setData({
        h: '1.心率过高人次/心率正常人次(正常心率60~100次/分)：' + all.rh,
        l: '2.心率过低人次/心率正常人次：' + all.rl,
      })
      var a = JSON.parse(all.jsonr_hS).length;
      var arrays = new Array();
      for (var i = 0; i < a; i++) {
        arrays[i] = {
          name: JSON.parse(all.jsonr_hS)[i].name,
          data: parseInt(JSON.parse(all.jsonr_hS)[i].data),
        }
      }
      pieChart = new wxCharts({
        animation: true,
        canvasId: 'pieCanvas',
        type: 'pie',
        series: arrays,
        width: windowWidth,
        height: 300,
        dataLabel: true,
      });
      var b = JSON.parse(all.jsonr_lS).length;
      var arrays2 = new Array();
      for (var i = 0; i < b; i++) {
        arrays2[i] = {
          data: parseInt(JSON.parse(all.jsonr_lS)[i].data),
          name: JSON.parse(all.jsonr_lS)[i].name,
        }
      }
      pieChart2 = new wxCharts({
        animation: true,
        canvasId: 'pieCanvas2',
        type: 'pie',
        series: arrays2,
        width: windowWidth,
        height: 300,
        dataLabel: true,
      });
    }else if (e.detail.value == 2) {   //1
      this.setData({
        h: '1.血压过高人次/血压正常人次(正常收缩压应<130mmHg，舒张压<85mmHg)：' + all.ph,
        l: '2.血压过低人次/血压正常人次：' + all.pl,
      })
      var a = JSON.parse(all.jsonp_hS).length;
      var arrays = new Array();
      for (var i = 0; i < a; i++) {
        arrays[i] = {
          name: JSON.parse(all.jsonp_hS)[i].name,
          data: parseInt(JSON.parse(all.jsonp_hS)[i].data),
        }
      }
      pieChart = new wxCharts({
        animation: true,
        canvasId: 'pieCanvas',
        type: 'pie',
        series: arrays,
        width: windowWidth,
        height: 300,
        dataLabel: true,
      });
      var b = JSON.parse(all.jsonp_lS).length;
      var arrays2 = new Array();
      for (var i = 0; i < b; i++) {
        arrays2[i] = {
          data: parseInt(JSON.parse(all.jsonp_lS)[i].data),
          name: JSON.parse(all.jsonp_lS)[i].name,
        }
      }
      pieChart2 = new wxCharts({
        animation: true,
        canvasId: 'pieCanvas2',
        type: 'pie',
        series: arrays2,
        width: windowWidth,
        height: 300,
        dataLabel: true,
      });
    }
  
   
  },
  touchHandler: function (e) {
    console.log(pieChart.getCurrentDataIndex(e));
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
    //console.log(',,,,,,,,,,,,');
   var that = this;

    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/data/getdata.do',
      success: function (res) {
        all.th = res.data.th;
        all.tl = res.data.tl;
        all.rh = res.data.rh;
        all.rl = res.data.rl;
        all.ph = res.data.ph;
        all.pl = res.data.pl,
        all.jsont_hS=JSON.stringify(res.data.jsont_h);
        all.jsont_lS = JSON.stringify(res.data.jsont_l);
        all.jsonr_hS = JSON.stringify(res.data.jsonr_h);
        all.jsonr_lS = JSON.stringify(res.data.jsonr_l);
        all.jsonp_hS = JSON.stringify(res.data.jsonp_h);
        all.jsonp_lS = JSON.stringify(res.data.jsonp_l);
        that.setData({
          time:res.data.time,
        })
        console.log(res.data.jsont_h);
        console.log(JSON.stringify(res.data.jsont_h));
        console.log(JSON.parse(JSON.stringify(res.data.jsont_h)));
        
      },
    })
    
   

  },
})