# NBMEcalc developer backlink ledger

Last audited: 2026-08-03

## Summary

- Canonical target: https://nbmecalc.com
- Completed public listings: 5
- Unique referring root domains: 5 (`github.io`, `sonatype.com`, `codeberg.org`, `gitea.com`, `gitbook.io`)
- Pending / prepared: 10 platform surfaces
- Blocked: none
- Rejected after qualification: 11 platforms

## Platforms

| Platform | Root domain | Public URL | Asset type | Link location | rel tokens | Index directives | Status | Evidence / next action |
|---|---|---|---|---|---|---|---|---|
| GitHub Pages | github.io | https://jiankn.github.io/nbmecalc-java/ | Java API documentation | Javadoc overview | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Exact target anchor verified 2026-08-03 |
| Maven Central | sonatype.com | https://central.sonatype.com/artifact/io.github.jiankn/nbmecalc-core/1.0.0 | Java library | POM Project URL | `noreferrer` | HTTP 200; canonical present; no `noindex`; no `X-Robots-Tag` | Complete | POM, main JAR, sources JAR, and Javadoc JAR returned HTTP 200; exact target anchor verified 2026-08-03. Central search API indexing is still propagating. |
| Read the Docs | readthedocs.io | Not created | API documentation | Documentation prose | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / deferred | Extra account and duplicate documentation maintenance; revisit after Maven Central release |
| CocoaPods | cocoapods.org | Not created | Swift library | Documentation metadata | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / deferred | Requires a maintained Swift implementation and macOS release path |
| JSR | jsr.io | Not created | TypeScript package | Rendered README product link | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Product-site link failed followability gate; verified repository link behavior does not help the canonical target |
| NuGet | nuget.org | Not created | .NET package | Homepage / documentation | `nofollow noopener noreferrer` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Packagist | packagist.org | Not created | PHP package | Homepage / README | `external nofollow noindex noopener ugc` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| RubyGems | rubygems.org | Not created | Ruby package | Homepage | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| VS Marketplace | marketplace.visualstudio.com | Not created | VS Code extension | README / repository links | `nofollow noopener noreferrer` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Libraries.io | libraries.io | Not created | Registry mirror | Homepage / README | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Codeberg | codeberg.org | https://codeberg.org/jiankn/nbmecalc-java | Java library mirror | Repository Website field | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Exact target anchor verified 2026-08-03; a separate README link is `nofollow`, while the repository Website link is followable |
| Gitea.com | gitea.com | https://gitea.com/jiankn/nbmecalc-java | Java library mirror | Repository Website field | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Exact target anchor verified 2026-08-03; a separate README link is `nofollow`, while the repository Website link is followable |
| GitBook | gitbook.io | https://savepinner.gitbook.io/nbmecalc-developer-documentation | Developer guide | Documentation prose | none | HTTP 200; `index, follow`; canonical present | Complete | Exact target anchor verified 2026-08-03 |
| DEV Community | dev.to | Not created | Technical tutorial | Article prose | `noopener noreferrer` | HTTP 200; no blocking robots; canonical present | Qualified / publish pending | Article draft is in `nbmecalc-developer-docs/docs/dev-article.md`; DEV account is logged in |
| Read the Docs | readthedocs.io | Not created | Developer documentation | Documentation prose | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / import pending | MkDocs strict build and GitHub CI passed; repository import remains |
| pkg.go.dev | pkg.go.dev | Propagating | Go library | Rendered README and repository metadata | one nofollow prose link plus one ordinary URL on representative page | HTTP 200; no `noindex`; canonical present on representative page | Published / propagating | `github.com/jiankn/nbmecalc-go` v1.0.0 is public and available from proxy.golang.org; pkg.go.dev page still returned 404 immediately after release |
| docs.rs | docs.rs | Not published | Rust library documentation | Homepage metadata | none on representative latest-version page | HTTP 200; no `noindex` on representative latest URL | Qualified / secret pending | `jiankn/nbmecalc-rust` v1.0.0 passed CI; crates.io publication requires repository secret `CARGO_REGISTRY_TOKEN` |
| Clojars | clojars.org | Not published | Clojure library | Project URL | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / secrets pending | `net.clojars.jiankn/nbmecalc` v1.0.0 passed CI; needs `CLOJARS_USERNAME` and `CLOJARS_TOKEN` |
| Hackage | hackage.haskell.org | Not published | Haskell library | Homepage metadata | none on representative page | HTTP 200; no `noindex`; canonical present | Qualified / secret pending | `nbmecalc` 1.0.0.0 passed CI; needs `HACKAGE_TOKEN` |
| CocoaPods | cocoapods.org | Not published | Swift library | Homepage metadata | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / secret pending | `NBMEcalc` 1.0.0 passed Swift tests and pod lint; needs `COCOAPODS_TRUNK_TOKEN` |
| DUB | code.dlang.org | Not registered | D library | Homepage and README | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / registration pending | `jiankn/nbmecalc-dlang` v1.0.0 passed CI and is public |
| Haxelib | lib.haxe.org | Not published | Haxe library | Project URL and README | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / upload pending | `jiankn/nbmecalc-haxe` v1.0.0 passed CI; release ZIP is attached to the GitHub release |
| Smithery | smithery.ai | Not listed | Remote MCP server | Repository / homepage link | `noopener noreferrer` on representative page | HTTP 200; no `noindex` on a valid representative listing | Qualified / listing pending | Remote Streamable HTTP MCP deployed at `https://nbmecalc-mcp.chenxuanshimo.workers.dev/mcp`; production health and initialization passed from GitHub-hosted verification |
| PyPI | pypi.org | Not created | Python package | Homepage / rendered README | `nofollow` | HTTP 200; no `noindex`; canonical present | Rejected | Failed followability gate after rendered-DOM audit |
| cljdoc | cljdoc.org | Not created | Clojure documentation | Rendered README | `nofollow` | HTTP 200; no `noindex` | Rejected | Failed followability gate; Clojars itself remains qualified |
| Hex / HexDocs | hex.pm / hexdocs.pm | Not created | Elixir package and docs | Homepage / README | `nofollow` | HTTP 200; no `noindex` | Rejected | Both package and generated documentation target links failed followability gate |
| pub.dev | pub.dev | Not created | Dart package | Homepage / README | `ugc` | HTTP 200; `noindex`; canonical present | Rejected | Failed both indexability and followability gates |
| Raku Land | raku.land | Not created | Raku module | Rendered README | `nofollow` | HTTP 200; no `noindex`; canonical present | Rejected | Failed followability gate |

Completed counts only include public pages where the final target link and page directives were directly audited. Multiple pages on the same root domain are deduplicated when counting referring domains.
