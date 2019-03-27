if(!this.sh_languages){this.sh_languages={}}var sh_requests={};function sh_highlightString(C,t,s){var z={_stack:[],getLength:function(){return this._stack.length
},getTop:function(){var i=this._stack;var E=i.length;if(E===0){return undefined}return i[E-1]
},push:function(i){this._stack.push(i)},pop:function(){if(this._stack.length===0){throw"pop on empty stack"
}this._stack.pop()}};var h=0;var p=undefined;var m=function(E,i){var F=E.length;if(F===0){return
}if(!i){var G=z.getTop();if(G!==undefined&&!("state" in G)){i=G.style}}if(p!==i){if(p){s.endElement()
}if(i){s.startElement(i)}}s.text(E);h+=F;p=i};var r=/\r\n|\r|\n/g;r.lastIndex=0;var y=C.length;
while(h<y){var g=h;var d;var v;var B=r.exec(C);if(B===null){d=y;v=y}else{d=B.index;
v=r.lastIndex}var n=C.substring(g,d);var k=null;var j=-1;for(;;){var b=h-g;var x=z.getTop();
var f=x===undefined?0:x.next;var e=t[f];var D=e.length;if(f!==j){k=[]}var a=null;
var o=-1;for(var w=0;w<D;w++){var l;if(f===j&&(k[w]===null||b<=k[w].index)){l=k[w]
}else{var c=e[w].regex;c.lastIndex=b;l=c.exec(n);k[w]=l}if(l!==null&&(a===null||l.index<a.index)){a=l;
o=w}}j=f;if(a===null){m(n.substring(b),null);break}else{if(a.index>b){m(n.substring(b,a.index),null)
}x=e[o];var q=x.style;var u;if(q instanceof Array){for(var A=0;A<q.length;A++){u=a[A+1];
m(u,q[A])}}else{u=a[0];m(u,q)}if("next" in x){z.push(x)}else{if("exit" in x){z.pop()
}if("exitall" in x){while(z.getLength()>0){z.pop()}}}}}if(p){s.endElement()}p=undefined;
if(B){s.text(B[0])}h=v}}function sh_getClasses(d){var a=[];var b=d.className;if(b&&b.length>0){var e=b.split(" ");
for(var c=0;c<e.length;c++){if(e[c].length>0){a.push(e[c])}}}return a}function sh_addClass(c,a){var d=sh_getClasses(c);
for(var b=0;b<d.length;b++){if(a.toLowerCase()===d[b].toLowerCase()){return}}d.push(a);
c.className=d.join(" ")}function sh_getText(c){if(c.nodeType===3||c.nodeType===4){return c.data
}else{if(c.nodeType===1&&c.tagName==="BR"){return"\n"}else{if(c.childNodes.length===1){return sh_getText(c.firstChild)
}else{var a="";for(var b=0;b<c.childNodes.length;b++){a+=sh_getText(c.childNodes.item(b))
}return a}}}}function sh_isEmailAddress(a){if(/^mailto:/.test(a)){return false}return a.indexOf("@")!==-1
}var sh_builder={init:function(b,a){while(a.hasChildNodes()){a.removeChild(a.firstChild)
}this._document=b;this._element=a;this._currentText=null;this._documentFragment=b.createDocumentFragment();
this._currentParent=this._documentFragment;this._span=b.createElement("span");this._a=b.createElement("a")
},startElement:function(b){if(this._currentText!==null){this._currentParent.appendChild(this._document.createTextNode(this._currentText));
this._currentText=null}var a=this._span.cloneNode(true);a.className=b;this._currentParent.appendChild(a);
this._currentParent=a},endElement:function(){if(this._currentText!==null){if(this._currentParent.className==="sh_url"){var b=this._a.cloneNode(true);
b.className="sh_url";var c=this._currentText;if(c.length>0&&c.charAt(0)==="<"&&c.charAt(c.length-1)===">"){c=c.substr(1,c.length-2)
}if(sh_isEmailAddress(c)){c="mailto:"+c}b.setAttribute("href",c);b.appendChild(this._document.createTextNode(this._currentText));
this._currentParent.appendChild(b)}else{this._currentParent.appendChild(this._document.createTextNode(this._currentText))
}this._currentText=null}this._currentParent=this._currentParent.parentNode},text:function(a){if(this._currentText===null){this._currentText=a
}else{this._currentText+=a}},close:function(){if(this._currentText!==null){this._currentParent.appendChild(this._document.createTextNode(this._currentText));
this._currentText=null}this._element.appendChild(this._documentFragment)}};function sh_highlightElement(b,a,d){sh_addClass(a,"sh_sourceCode");
var c;if(a.childNodes.length===0){return}else{c=sh_getText(a)}sh_builder.init(b,a);
sh_highlightString(c,d,sh_builder);sh_builder.close()}function sh_getXMLHttpRequest(){if(window.ActiveXObject){return new ActiveXObject("Msxml2.XMLHTTP")
}else{if(window.XMLHttpRequest){return new XMLHttpRequest()}}throw"No XMLHttpRequest implementation available"
}function sh_load(language,prefix,suffix){if(language in sh_requests){return}sh_requests[language]=1;
var request=sh_getXMLHttpRequest();var url=prefix+"sh_"+language+suffix;request.open("GET",url,true);
request.onreadystatechange=function(){if(request.readyState===4){try{if(request.status===0||request.status===200){eval(request.responseText);
var nodeList=document.getElementsByTagName("pre");for(var i=0;i<nodeList.length;i++){var element=nodeList.item(i);
var htmlClasses=sh_getClasses(element);for(var j=0;j<htmlClasses.length;j++){var htmlClass=htmlClasses[j].toLowerCase();
if(htmlClass==="sh_sourcecode"){continue}if(htmlClass==="sh_"+language){sh_highlightElement(document,element,sh_languages[language]);
break}}}}else{throw"HTTP error: status "+request.status}}finally{request=null}}};
request.send(null)}function sh_highlightHTMLDocument(h,g,l){var b=h.getElementsByTagName("pre");
for(var e=0;e<b.length;e++){var f=b.item(e);var a=sh_getClasses(f);for(var c=0;c<a.length;
c++){var k=a[c].toLowerCase();if(k==="sh_sourcecode"){continue}if(k.substr(0,3)==="sh_"){var d=k.substring(3);
if(d in sh_languages){sh_highlightElement(h,f,sh_languages[d])}else{if(typeof(g)==="string"&&typeof(l)==="string"){sh_load(d,g,l)
}else{throw"Found <pre> element with class='"+k+"', but no such language exists"}}break
}}}}function sh_highlightDocument(a,b){sh_highlightHTMLDocument(document,a,b)};