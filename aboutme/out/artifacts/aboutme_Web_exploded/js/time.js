let nowDate = document.querySelector("#nowDate").value;

function makeTime() {
  let date = new Date();
  let year = date.getFullYear();
  let month = date.getMonth() + 1;
  let day = date.getDate();
  let hours = date.getHours();
  let minutes = date.getMinutes();
  let seconds = date.getSeconds();

  // Add leading zero to single-digit numbers
  month = month < 10 ? "0" + month : month;
  day = day < 10 ? "0" + day : day;
  hours = hours < 10 ? "0" + hours : hours;
  minutes = minutes < 10 ? "0" + minutes : minutes;
  seconds = seconds < 10 ? "0" + seconds : seconds;

  nowDate =
    year +
    "-" +
    month +
    "-" +
    day +
    " " +
    hours +
    ":" +
    minutes +
    ":" +
    seconds;
  document.querySelector("#now-date").textContent = nowDate;
}

setInterval(makeTime, 1000);

/**
 *
 * @param dirNameArray
 * @param dirUrlArray
 * @param className String
 * @param linkUrl String
 */
// function appendList(dirNameArray, dirUrlArray, className, linkUrl) {
//   let arrayIndex = 0;
//   dirNameArray.forEach((dirName) => {
//     let aElement = document.createElement("a");
//     aElement.setAttribute("href", `${linkUrl}${dirUrlArray[arrayIndex]}`);
//     let pElement = document.createElement("p");
//     let pElementText = document.createTextNode(dirName);
//     pElement.appendChild(pElementText);
//     aElement.appendChild(pElement);
//     document.querySelector(`.${className}`).appendChild(aElement);
//     arrayIndex++;
//   });
// }
//
// appendList(dirNameList, dirUrlList, "ftp-content", "/aboutme/what-time?dir=");
